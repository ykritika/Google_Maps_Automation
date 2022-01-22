Feature: Google Maps

Scenario: Validate Google maps route 
Given initialize the browser
And navigate to google maps
When search city in searchbox
Then prints routes information
And close the browser
