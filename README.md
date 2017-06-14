# my-elasticsearch
this is my elasticsearch learning

## Install elastic search on mac
the version of spring-data-elasticsearch is 2.1.4.RELEASE

due to compatibility, elasticsearch-2.4.5 is recommend .

## Interact in DSL
### Set up on chrome
1. install sense plugin on chrome
2. set server to local: http://localhost:9200
3. get cluster name, it will be used in spring elasticsearch code: 

```curl -XGET 'http://localhost:9200/_nodes/cluster_name'```
### Query in DSL:
#### put data:
```$xslt
POST /cars/transactions/_bulk
{ "index": {}}
{ "price" : 10000, "color" : "red", "make" : "honda", "sold" : "2014-10-28" }
{ "index": {}}
{ "price" : 20000, "color" : "red", "make" : "honda", "sold" : "2014-11-05" }
{ "index": {}}
{ "price" : 30000, "color" : "green", "make" : "ford", "sold" : "2014-05-18" }
{ "index": {}}
{ "price" : 15000, "color" : "blue", "make" : "toyota", "sold" : "2014-07-02" }
{ "index": {}}
{ "price" : 12000, "color" : "green", "make" : "toyota", "sold" : "2014-08-19" }
{ "index": {}}
{ "price" : 20000, "color" : "red", "make" : "honda", "sold" : "2014-11-05" }
{ "index": {}}
{ "price" : 80000, "color" : "red", "make" : "bmw", "sold" : "2014-01-01" }
{ "index": {}}
{ "price" : 25000, "color" : "blue", "make" : "ford", "sold" : "2014-02-12" }
```
#### get all:
```
GET _search
{
   "query": {
       "match_all": {}
   }
}
```
### aggragate:
```$xslt
GET /cars/transactions/_search
{
    "size" : 0,
    "aggs" : { 
        "popular_colors" : { 
            "terms" : { 
              "field" : "color"
            }
        }
    }
}
```

### delete:
curl -XDELETE 'http://localhost:9200/twitter/tweet/1'

```DELETE the-cars```
### mapping:
```GET _mapping?pretty=true```

### search:
```GET _search
   {
      "query": {
          "match": {
             "brand": "BMW X5"
          }
      }
      , "size": 1
   }
 ```
 
 
## MAVEN PROJECT
### 1. start a maven project 
 https://start.spring.io/
### 2. 