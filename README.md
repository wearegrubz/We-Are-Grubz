# Group D Milestone 1: Grubz

## Table of Contents

1. Overview
2. Product Spec
3. Wireframes
4. Schema


## Overview

### Description

Grubz is an interactive app that allows friends to get together, decide on their tastes to eat, and quickly find a spot to eat

### App Evaluation
- **Category:** Food
- **Story:** Creates group session of friends, analyzes taste preferences of group members, recommends local food spots
- **Market:** Anyone with friends can use this
- **Habit:** The app can be used as often or unoften as the user wanted, depending on their taste
- **Scope:** First we can start with finding spots for restaurants in the Tallahassee area but after that we could expand to our capacities limit


## Product Spec

### 1. User Stories (Required and Optional)
**Required Must-have Stories**

For Grubz, we identified the following "must-have" features which a user needs to be able to perform for the app to work:

- User creates an account
- User can send out group invite
- User selects taste preferences
- User can login
- Users can vote for top 3 food spots recommended

**Optional Nice-to-have Stories**

- User has opt out option
- User can view map with recommendations

### 2. Screen Archetypes

Based on your required user stories, the next step is identifying your [core screen archetypes](https://guides.codepath.com/android/Mobile-Screen-Archetypes), these are the different screens your app will have to have to function. For example:

- Login
    - User can login
- Account Creation
    - User can create a new account
- Group Creation
    - User can create a group session
    - User can invite friends to group
    - User can display QR code
- Taste Selection
    - User selects what they have a taste for and preferences
    - Search for preferences
- Recommendations
    - User can view map that displays local restaurants
    - User can view recommended food spots
    - User can vote for top 3
- Account
    - User can see account details
    - User can edit account details

### 3. Navigation

**Tab Navigation** (Tab to Screen)

- Landing Page
    - Login
    - Create Account
- Login
    - Group Creation
- Create Account
    - Group Creation
- Group Creation
    - Taste Selection
    - Account
- Taste Selection
    - Recommendation
- Recommendations
    - Account
    - Group Creation


## Wireframes
![wireframes-1](https://user-images.githubusercontent.com/91871697/193975039-84436257-51c3-4ec9-942f-b2a227eac83d.png)


## Updated Wireframes
![wireframes-2](https://user-images.githubusercontent.com/92326654/204020974-0322fd2c-0c0f-4d05-af81-9b6a12c377d1.jpeg)
![wireframes-3](https://user-images.githubusercontent.com/92326654/204934119-cae6280c-122b-4778-9c60-a61bbf079d99.jpeg)


## Digital Wireframes & Mockups
![image](https://user-images.githubusercontent.com/91871697/193973814-964fa898-47f9-4add-b178-f5f8f5d57f55.png)


## Schema

### Models

**User**
| Property | Type   | Description            |
|----------|--------|------------------------|
| userId   | String | unique ID for the user |
| email    | String | user's email           |
| fullName | String | user's full name       |
| password | String | user's password        |

**Session**
| Property          | Type   | Description                                |
|-------------------|--------|--------------------------------------------|
| sessionId         | String | unique ID for the session                  |
| link              | String | unique link to session                     |
| host              | String | ID of user that hosts session              |
| users             | Array  | array storing users in session (by userId) |
| location          | String | user's street address/zip code             |
| radius            | int    | user's specified radius preference         |
| recommendations   | Array  | restaurant IDs                             |

**Taste**
| Property  | Type   | Description                                 |
|-----------|--------|---------------------------------------------|
| userId    | String | unique ID for the user                      |
| sessionId | String | unique ID for the session                   |
| cuisine   | Array  | array storing users' tastes for the session |

### Networking

**List of network requests by screen**

- Create Account
    - (Create/POST) Creating a new account
- Generate Group
    - (Create/POST) Creating a group session
- Taste Selection
    - (Create/POST) Creating a taste
- Recommendations
    - (Read/GET) Get Users in group
    - (Read/GET) Get recommendations

## Gif Walkthrough
![grubz_gif](https://user-images.githubusercontent.com/56606742/206838336-b7161d52-7f9a-4916-9e27-8ffa3597185a.gif)



