package com.example.avantageevents.bot.constant;

/**
 * @author Malikov Azizjon  *  01.02.2023  *  21:40   *  AvantageEvents
 */
public interface ConstantRu {

    String START = """
            Здравствуйте! Добро пожаловать в наш бот!\s
            Для начала выберите язык обслуживания:
            """;
    String BUTTON = "Русский \uD83C\uDDF7\uD83C\uDDFA";
    String CONTACT_BUTTON = "Отправить контакт \uD83D\uDCDE";
    String CONTACT = """
            Введите свой номер телефона
            \s
            Отправить номер с помощью кнопки <ОТПРАВИТЬ КОНТАКТ>""";
    String ABOUT_US_BUTTON = "О нас \uD83D\uDD0E";
    String SERVICES_BUTTON = "Услуги \uD83D\uDEE0";
    String EVENTS_BUTTON = "Выставки \uD83D\uDCBB";
    String SETTINGS_BUTTON = "Настройки ⚙";
    String VACANCY_BUTTON = "Вакансия \uD83D\uDC68\uD83C\uDFFB\u200D\uD83D\uDCBB";
    String MENU = "Главное меню : ";
    String ABOUT_US = """
            <b>ООО AVANTAGE</b>\s
            \s
            \uD83C\uDF10 <a href="https://cio.teda.uz/"> cio.teda.uz</a>
            ☎ <b>+998 (95) 144 04 40  +998 (97) 716 63 44</b>
            \uD83D\uDCCD <b>г Ташкент, Мирзо-Улугбекский р-н, проспект Мирзо-Улугбека 87</b>
            \uD83C\uDF10 <a href="https://cio.uz/">CIO.uz</a>
            <b>Оставьте свой вопрос нашему менеджеру и</b>
            <b> наш менеджер ответит вам в ближайшее время.</b>
            \uD83D\uDC64 <b>Менеджер : info@avantage.events</b>\s""";
    //            \uD83C\uDFE6<b>Х/р: 20208000800895476001, РАКБ «Давр Банк» Мирзо Улугбекский филиал г. Ташкент</b>\s
//            <b>МФО: 01072 ИНН: 305626506  ОКЭД: 82990</b>\s""";
    String VACANCY = "Вакансий пока нет \n";
    //            "\uD83D\uDC64 Менеджер : @Proekt_Manager\n";
    String LANGUAGE = "Изменить язык \uD83C\uDDF7\uD83C\uDDFA/\uD83C\uDDFA\uD83C\uDDFF/\uD83C\uDDEC\uD83C\uDDE7";
    String PHONE = "Изменить номер \uD83D\uDCDE";
    String BACK = "Назад ⬅";
    String CHOOSE = "Выберите: ";
    String EDITED = "Успешно изменен \uD83C\uDD97";
    String CHOOSE_LANGUAGE = "Пожалуйста выберите язык:";
    String LANGUAGE_ICON = "RUS \uD83C\uDDF7\uD83C\uDDFA";
    String IN_DETAIL = "Подробно\uD83D\uDD0E";
    String REQUEST = "Заявка\uD83D\uDCCC";
    //    String RESPONSE_FOR_REQUEST= "Ваш запрос успешно получен.✅\n" +
//            "Наш менеджер свяжется с вами в ближайшее время.";
    String RESPONSE_FOR_REQUEST = "Ваш запрос успешно получен.✅\n" +
            "";
    String MY_REQUESTS = "Мои Выставки \uD83C\uDFAF";

    String MY_REQUESTS_EMPTY = "У вас пока нет заявки";
    String SELECT_COUNTRY = "Пожалуйста, пришлите мне код вашего округа \n (Пример: Uzbekistan -> Uz)";
    String ERROR_COUNTRY = "По введенной вами информации не найдено информации.\n" +
            "Пожалуйста, введите еще раз:";
    String SELECT_REGION = "Пожалуйста, выберите свой регион: ";
    String ABOUT_COMPANY = "Напишите о своей компании: ";
    String ABOUT_COMPANY_IF_NOT_BUTTON = "У меня нет компании ";
    String  HOW_KNOW = "Как вы узнали о нас?";
    String TV_KNOW_BUTTON = "Через Телевидение \uD83D\uDCFA";
    String INTERNET_KNOW_BUTTON = "Через Интернет \uD83C\uDF10";
    String ADVERTISING_KNOW_BUTTON = "Через Рекламу \uD83D\uDCE3";
    String EMAIL_KNOW_BUTTON = "По Электронной Почте \uD83D\uDCE7";
    String ANOTHER_KNOW_BUTTON = "Через Другие Источники ";
}
