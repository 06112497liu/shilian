# 失联mapping
DELETE bbd
PUT /bbd
{
  "settings": {
    "number_of_replicas": 0,
    "number_of_shards": 1
  },
  "mappings": {
    "company": {
      "properties": {
        "abnormal": {
          "type": "long"
        },
        "activity": {
          "type": "long"
        },
        "addr": {
          "type": "text"
        },
        "businessStatus": {
          "type": "long"
        },
        "city": {
          "type": "text"
        },
        "companyCreditCode": {
          "type": "text"
        },
        "companyName": {
          "type": "text",
          "analyzer": "ik_max_word",
          "search_analyzer": "ik_max_word"
        },
        "companyPropoerty": {
          "type": "long"
        },
        "companyPropoertyDesc": {
          "type": "text"
        },
        "companyType": {
          "type": "text"
        },
        "district": {
          "type": "text"
        },
        "emails": {
          "type": "text"
        },
        "gmtApproval": {
          "type": "text"
        },
        "gmtCompanyRegister": {
          "type": "text"
        },
        "gmtSuspend": {
          "type": "text"
        },
        "id": {
          "type": "long"
        },
        "industryDesc": {
          "type": "text"
        },
        "latLng": {
          "properties": {
            "lat": {
              "type": "float"
            },
            "lng": {
              "type": "float"
            }
          }
        },
        "legalPerson": {
          "type": "text"
        },
        "lostTime": {
          "type": "text"
        },
        "nbxh": {
          "type": "text"
        },
        "operateScope": {
          "type": "text"
        },
        "phones": {
          "type": "text"
        },
        "primaryIndustry": {
          "type": "text"
        },
        "province": {
          "type": "text"
        },
        "registerAuthority": {
          "type": "text"
        },
        "registerCapital": {
          "type": "float"
        },
        "registerNumber": {
          "type": "text"
        },
        "score": {
          "type": "float"
        }
      }
    }
  }
}
