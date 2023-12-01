# sam9moFinance


# User-Service API 명세서
사용자 어플 서비스 API 명세서

## Version: v1

### /member

#### GET
##### Summary:

회원 정보 조회

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| Refresh-Token | header |  | No | string |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

#### PUT
##### Summary:

회원 정보 수정

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| Refresh-Token | header |  | No | string |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

#### DELETE
##### Summary:

회원 탈퇴

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| Refresh-Token | header |  | No | string |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /admin/news

#### PUT
##### Summary:

하나의 뉴스 업데이트

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| Refresh-Token | header |  | No | string |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

#### POST
##### Summary:

최신 뉴스 15개씩 페이징

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| Refresh-Token | header |  | No | string |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

#### DELETE
##### Summary:

하나의 뉴스 삭제

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| Refresh-Token | header |  | No | string |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /admin/members

#### GET
##### Summary:

회원 목록 조회

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| Refresh-Token | header |  | No | string |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

#### PUT
##### Summary:

회원 목록 수정

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| Refresh-Token | header |  | No | string |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

#### DELETE
##### Summary:

회원 목록 삭제

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| Refresh-Token | header |  | No | string |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /sign-up

#### POST
##### Summary:

회원 가입

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| Refresh-Token | header |  | No | string |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /sign-in

#### POST
##### Summary:

로그인

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| Refresh-Token | header |  | No | string |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /admin/admins

#### GET
##### Summary:

관리자 목록 조회

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| Refresh-Token | header |  | No | string |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |
