package com.cookieIT.exampleApp.ExampleApp.infrastructure.ldap;

import java.util.List;
import com.cookieIT.exampleApp.ExampleApp.common.ad.AdPerson;

public interface AdPersonRepository {

    List<AdPerson> getPersonNamesFromGroup(String groupName);
}
