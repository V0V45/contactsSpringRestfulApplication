# Spring RESTful Service - web приложение списка контактов

## Как пользоваться
1) Запускается ApplicationMain, тем самым запустится сервер на localhost:8080
2) Отправляются запросы следующего типа:
- Создать контакт:
POST localhost:8080/contacts?name=**имя_контакта**&surname=**фамилия_контакта**&email=**email_контакта**&phone=**номер_телефона_контакта**
*(важно учесть, что номер телефона и email проверяется регулярным выражением)*
- Получить список всех контактов:
GET localhost:8080/contacts
- Получить отдельный контакт:
GET localhost:8080/contacts/**ID_контакта**
- Изменить отдельный контакт:
PUT localhost:8080/contacts/**ID_контакта**?name=**имя_контакта**&surname=**фамилия_контакта**&email=**email_контакта**&phone=**номер_телефона_контакта**
*(можно изменять контакт только по одному параметру, вводить все сразу не обязательно)*
- Удалить отдельный контакт:
DELETE localhost:8080/contacts/**ID_контакта**
*(при удалении контакта ID всех остальных контактов не изменяется, однако, следующий новый контакт будет добавлен на место пустого ID)*

## Примеры запросов
- POST localhost:8080/contacts?name=Vladislav&surname=Valov&email=vladvalov@gmail.com&phone=75555501210
- GET localhost:8080/contacts
- GET localhost:8080/contacts/5
- PUT localhost:8080/contacts/3?surname=Nikolaev
- DELETE localhost:8080/contacts/2

## Файлы
### src/main/java/com/contacts/app
- ApplicationMain.java - файл запуска приложения Spring Boot, содержит Main-метод
### src/main/java/com/contacts/app/controller
- Controller.java - REST-Controller файл, содержащий все HTTP-запросы, которые обрабатывает REST API
### src/main/java/com/contacts/app/model
- Contact.java - объектно-ориентированная модель контакта
- ContactsProcessor.java - класс, который работает со списком контактов (позволяет добавлять контакт в список, удалить контакт из списка, изменить контакт в списке и так далее)