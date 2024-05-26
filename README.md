# Vet Management System

#### A program developed for vet.
- Saves veterinary doctors.
- Saves working days (available days) of doctors.
- Saves customers.
- Saves the animals belonging to the customers.
- Saves the vaccines administered to the animals with their dates.
- Creates appointments with veterinarians for animals.

#### Technologies used :
- PostgreSQL
- Spring Boot,
- Spring Web,
- Spring Boot Dev Tools,
- Spring Data Jpa,
- Lombok,
- ModelMapper,
- Validation

## Entities
- Animal
- Appointment,
- Available Date,
- Customer,
- Doctor,
- Vaccine,

## UML Diagram

![UML](https://github.com/TalhaTopaloglu/Vet-Management-System/blob/main/UML_Vet.JPG)

# Endpoits

## Animal
| Http | Endpoint | Description |
|--|--|--|
| GET | /v1/animals | Lists all animals |
| GET | /v1/animals/{id} | Lists animals by id |
| GET | /v1/animals/name/{name} | Lists animals by name animals |
| GET | /v1/animals/customer/{customerName} | Lists the animals belonging to the customer according to the customer name. |
| POST | /v1/animals | Adds a new animal. |
| PUT | /v1/animals | Updates animals. |
| DELETE | /v1/animals/{id} | Deletes animals according to id.|

## Appointment
| Http | Endpoint | Description |
|--|--|--|
| GET | /v1/appointments | Lists all appointments |
| GET | /v1/appointments/{id} | Lists appointments by id |
| GET | /v1/appointments/doctor/{doctorId}/start-date/{startDateTime}/end-date/{finishDateTime} | Lists appointment by doctor id and appointment date |
| GET | /v1/appointments/animal/{animalId}/start-date/{startDateTime}/end-date/{finishDateTime} | Lists appointment by animal id and appointment date  |
| POST | /v1/appointments | Adds a new appointment. |
| PUT | /v1/appointments | Updates appointments. |
| DELETE | /v1/appointments/{id} | Deletes appointents according to id |

## Availablale Date
| Http | Endpoint | Description |
|--|--|--|
| GET | /v1/available-dates | Lists all available dates |
| GET | /v1/available-dates /{id} | Lists available date by id |
| POST | /v1/available-dates  | Adds a new available date. |
| PUT | /v1/available-dates  | Updates available date. |
| DELETE | /v1/available-dates/{id} | Deletes available date according to id |

## Customer
| Http | Endpoint | Description |
|--|--|--|
| GET | /v1/customers | Lists all customers |
| GET | /v1/customers/{id} | Lists customers by id |
| GET | /v1/customers/name/{name} | Lists customers by name customers |
| POST | /v1/customers | Adds a new customer. |
| PUT | /v1/customers | Updates customers. |
| DELETE | /v1/customers/{id} | Deletes customers according to id.|

## Doctor
| Http | Endpoint | Description |
|--|--|--|
| GET | /v1/doctors | Lists all doctors |
| GET | /v1/doctors/{id} | Lists doctors by id |
| POST | /v1/doctors  | Adds a new doctor. |
| PUT | /v1/doctors  | Updates doctors. |
| DELETE | /v1/doctors/{id} | Deletes doctors according to id |


## Vaccine
| Http | Endpoint | Description |
|--|--|--|
| GET | /v1/vaccines | Lists all vaccines |
| GET | /v1/vaccines/{id} | Lists vaccines by id |
| GET | /v1/vaccines/animal/{id} | Lists vaccines by animal id |
| GET | /v1/vaccines/protection-date/protection-date/start-date/{startDate}/end-date/{endDate} | Lists vaccines by protection date |
| POST | /v1/vaccines  | Adds a new vaccine. |
| PUT | /v1/vaccines  | Updates vaccines. |
| DELETE | /v1/vaccines/{id} | Deletes vaccines according to id |

