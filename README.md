# my-elasticsearch
this is my elasticsearch learning

## Install elastic search on mac
### 1. brew install elasticsearch
### 2. start the elasticsearch service
commands:
- brew services list
- brew services restart elasticsearch
- brew services stop elasticsearch
- brew services start elasticsearch

## Interact in DSL
### Set up on chrome
1. install sense plugin on chrome
2. set server:http://localhost:9200
### query in DSL:
#### 1. get all:
```
GET _search
{
   "query": {
       "match_all": {}
   }
}
```
###
## MAVEN PROJECT
### 1. start a maven project 
 https://start.spring.io/
### 2. 