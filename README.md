## Приложение "Заметки"

Данное приложение "Заметки" позволяет выполнять запросы через REST контроллеры и REST API. Для выполнения запросов используйте следующий базовый URL: `http://localhost:8080/`.

**Конфигурация**
- Нужно создать базу с названием `notes`
- Обновить фаил `application.properties` в `src/main/resources` поменяв `user` и `password` на свои

Ниже перечислены доступные запросы:

1. **Добавление заметки** (`/new_note`):
   - Тип запроса: `POST`
   - Тело запроса: JSON объект, содержащее саму заметку и заголовок.

2. **Редактирование заметки** (`/update_note`):
   - Тип запроса: `POST`
   - Тело запроса: JSON объект, содержащий `id` заметки, новый текст и новый заголовок.

3. **Удаление заметки** (`/delete_note`):
   - Тип запроса: `DELETE`
   - Тело запроса: JSON объект, содержащий `id` заметки, которую требуется удалить.

4. **Просмотр заметки** (`/get_note`):
   - Тип запроса: `POST`
   - Тело запроса: JSON объект, содержащий `id` заметки, которую требуется просмотреть.

5. **Просмотр всех заметок** (`/get_all_notes`):
   - Тип запроса: `GET`

Пожалуйста, используйте удобное вам инструментальное средство, к примеру [Postman](https://www.postman.com/), для выполнения запросов к REST API приложения.
