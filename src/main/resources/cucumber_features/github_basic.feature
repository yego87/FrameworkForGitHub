Feature: Github basic test
#comment is here - feature description for search testing

#recurrent actions/preconditions go below - in "Background" section
#this section is optional. 
#Uncomment it and delete/comment duplicating step from Scenario description
#Background:
#Given user navigates to github home page

@smokeTest
Scenario: Github login
Given user navigates to github home page
When  click signIn button
And   enters user credentials and submits login form
Then  github repo home page is displayed
