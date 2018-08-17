package com.cookieIT.exampleApp.ExampleApp.infrastructure.ldap.impl;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.stereotype.Service;
import com.cookieIT.exampleApp.ExampleApp.common.ad.AdPerson;
import com.cookieIT.exampleApp.ExampleApp.infrastructure.ldap.AdPersonRepository;

@Service
public class AdPersonRepositoryImpl implements AdPersonRepository {

    private static final String LDAP_QUERY_ATTRIBUTE_CN = "cn";
    private static final String LDAP_QUERY_ATTRIBUTE_UID = "uid";

    private final LdapTemplate ldapTemplate;

    @Autowired
    public AdPersonRepositoryImpl(LdapTemplate ldapTemplate) {
        this.ldapTemplate = ldapTemplate;
    }

    public List<AdPerson> getPersonNamesFromGroup(String groupName) {

        AndFilter andFilter = new AndFilter();
        andFilter.and(new EqualsFilter("objectclass", "person"));
        andFilter.and(new EqualsFilter("memberof", "cn=" + groupName + ",ou=groups,dc=memorynotfound,dc=com"));
        return ldapTemplate.search("", andFilter.encode(), new UserAttributesMapper());
    }

    private class UserAttributesMapper implements AttributesMapper<AdPerson> {

        @Override
        public AdPerson mapFromAttributes(Attributes attrs) throws NamingException {
            AdPerson person = new AdPerson();

            if (attrs.get(LDAP_QUERY_ATTRIBUTE_CN) != null) {
                person.setName((String) attrs.get(LDAP_QUERY_ATTRIBUTE_CN)
                                             .get());
            }
            if (attrs.get(LDAP_QUERY_ATTRIBUTE_UID) != null) {
                person.setLogin((String) attrs.get(LDAP_QUERY_ATTRIBUTE_UID)
                                              .get());
            }

            return person;
        }

    }
}
