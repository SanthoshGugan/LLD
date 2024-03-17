# Rate Limiter

Rate Limiter is a service which limits requests per threshold. Threshold can be user identifier or any other capacity limitations. 
This service has to be deployed on cloud for scalable and highly available services.

## Functional Requirements

For simplicity, lets take single scenario for rate limiting.

- Requests should be rate limited by user identifier: UserSid
- Each user should be rate limited by rolling window of configured value `N` to max of `M`. For example, `N = 1 min`, `M = 5`, each user on any 1 min should have max of 5 requests.

## Non Functional Requirements

- Rate Limiter Service should be highly available. 
- Service should be highly scalable across many service.


## Extended Functional Requirements

- Each service which needs to be rate limited should be easily configurable to rate limiting service without any code change
- Add more strategies to rate limiting.
  - Fixed Window
  - Leaky Bucket
- Strategy for rate limiting should be configurable to each service without coding changes




