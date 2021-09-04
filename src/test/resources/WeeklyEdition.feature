Feature: Weekly Edition
  Chief editor add topics to the magazine

  Scenario: Chief editor add Topics for new edition
    Given Layer weekly magazine edition kicked off
    When Chief editor add topic to magazine edition
    Then Topics successfully added to magazine edition

  Scenario: Journalist submit draft article for publishing
    Given Topics has been added to the new edition
    When Journalist submits draft article
    Then Draft article saved and can be accessed by Copywriters

  Scenario: Copywriter suggests changes in draft article
    Given Draft article has been published by journalist
    When Copywriter suggest changes to article
    Then Suggested changes are saved for article and can be accessed by journalist

