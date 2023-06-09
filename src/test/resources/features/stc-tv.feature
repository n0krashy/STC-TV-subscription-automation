Feature: STC TV
  Background: open page
    Given I have opened the link

  Scenario Outline: validate every country packages
    * change country if not "<country>"
    Given I am on "<country>"'s page
    Then the currency should be "<currency>"
    * the lite package price should be <litePackagePrice>
    * the classic package price should be <classicPackagePrice>
    * the premium package price should be <premiumPackagePrice>
    Examples:
      | country | currency | litePackagePrice | classicPackagePrice | premiumPackagePrice |
      | KSA     | SAR      | 15               | 25                  | 60                  |
      | Kuwait  | KWD      | 1.2              | 2.5                 | 4.8                 |
      | Bahrain | BHD      | 2                | 3                   | 6                   |


