$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./src/test/java/features/test.feature");
formatter.feature({
  "name": "New York Times Home Page",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify sections",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I am on the New York Times home page",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepsDefinition.I_visit_nytimes()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see the sections button",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepsDefinition.iShouldSeeTheElement()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on the sections button",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepsDefinition.iClickOnTheElement()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see the correct sections",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepsDefinition.iShouldSeeTheCorrectSections()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Search",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I am on the New York Times home page",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepsDefinition.I_visit_nytimes()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see the search icon",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepsDefinition.iShouldSeeTheSearchIcon()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on the search icon",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepsDefinition.iClickOnTheSearchIcon()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search for \"football\"",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepsDefinition.search_for(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see \"football\" in the result page",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepsDefinition.iShouldSeeInTheResultPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select sort by \"newest\"",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepsDefinition.iSelectSortBy(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});