# Bank API

This is a very simple Spring Boot REST application that implements some simple bank operations.

**Endpoints implemented so far:**

**Client**

*@POST client/create* - receives a JSON containing client info (see class `ClientDTO`) and creates a new client.
Returns the new client info.

**Endpoints still to be implemented (WIP):**
- Create account
- Get account info
- Execute deposit
- Execute transfer between accounts
- Get client info
- Get transactions (bank statement)
- Edit client info
- Delete account/client
- Money withdrawal
