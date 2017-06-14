# my-elasticsearch
this is my elasticsearch learning

## Install elastic search on mac
### install elasticsearch by brew:
1. ```brew install elasticsearch```
2.  configuration file: /usr/local/etc/elasticsearch/elasticsearch.yml
### start the elasticsearch service
commands:
```
- brew services list
- brew services restart elasticsearch
- brew services stop elasticsearch
- brew services start elasticsearch
```

## Interact in DSL
### Set up on chrome
1. install sense plugin on chrome
2. set server to local: http://localhost:9200
3. get cluster name, it will be used in spring elasticsearch code: 

```curl -XGET 'http://localhost:9200/_nodes/cluster_name'```
### Query in DSL:
#### get all:
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