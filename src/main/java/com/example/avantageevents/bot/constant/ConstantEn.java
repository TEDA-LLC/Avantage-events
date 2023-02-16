package com.example.avantageevents.bot.constant;

/**
 * @author Malikov Azizjon  *  01.02.2023  *  21:41   *  AvantageEvents
 */
public interface ConstantEn {

    String START = """
            Hello! Welcome to our bot!\s
            First select the service language:
            """;
    String BUTTON = "English \uD83C\uDDEC\uD83C\uDDE7";
    String CONTACT_BUTTON = "Share contact \uD83D\uDCDE";
    String CONTACT = """
            Enter your phone number
            \s
            Send number using <Share contact> button""";
    String ABOUT_US_BUTTON = "About us \uD83D\uDD0E";
    String SERVICES_BUTTON = "Services \uD83D\uDEE0";
    String EVENTS_BUTTON = "Events \uD83D\uDCBB";
    String SETTINGS_BUTTON = "Settings ⚙";
    String VACANCY_BUTTON = "Vacancy \uD83D\uDC68\uD83C\uDFFB\u200D\uD83D\uDCBB";
    String MENU = "Main menu : ";
    String ABOUT_US = """
            <b>AVANTAGE LLC</b>\s
            \s
            \uD83C\uDF10 <a href="https://cio.teda.uz/"> cio.teda.uz</a>
            ☎ <b>+998 (95) 144 04 40  +998 (97) 716 63 44</b>
            \uD83D\uDCE7 <b>info@avantage.events</b>
            \uD83D\uDCCD <b>Tashkent C, Mirzo Ulugbek district, Mirzo Ulugbek street 87</b>
            \uD83D\uDCF8 <a href="https://www.instagram.com/avantage.events.agency/">@avantage.events.agency</a>
            <b>Leave your question to our manager and </b>
            <b> our manager will answer you as soon as possible.</b>
            \uD83D\uDC64 <b> Manager : info@avantage.events</b>\s""";
//            \uD83C\uDFE6<b>Х/р: 20208000800895476001, РАКБ «Davr Bank» Mirzo Ulugbek branch Tashkent C</b>\s
//            <b>МФО: 01072 ИНН: 305626506  ОКЭД: 82990</b>\s""";
    String VACANCY = "There are currently no vacancies\n" ;
    //            "\uD83D\uDC64 Manager : @Proekt_Manager\n";
    String LANGUAGE = "Change language \uD83C\uDDF7\uD83C\uDDFA/\uD83C\uDDFA\uD83C\uDDFF/\uD83C\uDDEC\uD83C\uDDE7";
    String PHONE = "Change number \uD83D\uDCDE";
    String BACK = "Back ⬅";
    String CHOOSE = "Choose: ";
    String EDITED = "Successfully modified \uD83C\uDD97";
    String CHOOSE_LANGUAGE = "Choose language:";
    String LANGUAGE_ICON = "ENG \uD83C\uDDEC\uD83C\uDDE7";
    String IN_DETAIL = "In Detail\uD83D\uDD0E";
    String REQUEST = "Request\uD83D\uDCCC";
    //    String RESPONSE_FOR_REQUEST = "Your request has been successfully received.✅\n" +
//            "Our manager will contact you soon.";
    String RESPONSE_FOR_REQUEST = "Your request has been successfully received.✅\n" +
            "";
    String MY_REQUESTS = "My Events \uD83C\uDFAF";
    String MY_REQUESTS_EMPTY = "You don't have any requests";

    String SELECT_COUNTRY = "Please send me code your county \n (Example: Uzbekistan -> Uz)";
    String ERROR_COUNTRY = "No information was found for the information you entered.\n" +
            "Please re-enter: ";
    String SELECT_REGION = "Please choose your region: ";
}
