# mysec
# auth0-sample-api

curl --request POST \
  --url https://alj-poc.au.auth0.com/oauth/token \
  --header 'content-type: application/json' \
  --data '{"client_id":"lPiAxXjiPYIRGxGYz2a7q83dxNTC5Bnc","client_secret":"46K75WOnZqpCMoPxXXnGYUi8U-OC0RljhW8-Adi9Dc5GP5HTkSkueRHCLVM7hEvJ","audience":"https://alj-poc.au.auth0.com/api/v2/","grant_type":"client_credentials"}'


curl --request GET \
  --url http://localhost:3010/api/private \
  --header 'authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6ImttV0w1UnNJMEJtLThFZEt4TUdmeiJ9.eyJpc3MiOiJodHRwczovL2Fsai1wb2MuYXUuYXV0aDAuY29tLyIsInN1YiI6ImxQaUF4WGppUFlJUkd4R1l6MmE3cTgzZHhOVEM1Qm5jQGNsaWVudHMiLCJhdWQiOiJodHRwczovL2Fsai1wb2MuYXUuYXV0aDAuY29tL2FwaS92Mi8iLCJpYXQiOjE2MDkyOTkwNzQsImV4cCI6MTYwOTM4NTQ3NCwiYXpwIjoibFBpQXhYamlQWUlSR3hHWXoyYTdxODNkeE5UQzVCbmMiLCJzY29wZSI6InJlYWQ6dXNlcnMgdXBkYXRlOnVzZXJzIGNyZWF0ZTp1c2VycyIsImd0eSI6ImNsaWVudC1jcmVkZW50aWFscyJ9.Jk2X1EDXAfwR9J14h0Gm1u-p-XpVMj65dFvHm_GnO1yoac5WfEHMhdHJhi3HoiDO2sPoEdKE6tS2xms7uimJhWBYoqTHYBM8fB8yPcw07Paj7zAUUFvIQ-1GTFVUbDBF-Z_SNJn0f8qIrnp_jpvO6FOc0fAwKQ5dVny8GBXERLyRkUHLsE9GRT8qR1xJ06HIt3wHkZkCF1NB2qcinPQqj_OECDdXesMnxNnRDLMc5xQXITesbQoTEQ843Ldnvx0Tao17iyD_3mxJ2C8VaxgF1mAN2xQ84Kn-B0ZGWsqE58Tg4OrTYWKf9zMMa-ScR6W6JERsAMUYmtjetzszsOcHdA'
