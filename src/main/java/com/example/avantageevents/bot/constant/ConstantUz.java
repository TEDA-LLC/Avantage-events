package com.example.avantageevents.bot.constant;

/**
 * @author Malikov Azizjon  *  01.02.2023  *  21:39   *  AvantageEvents
 */
public interface ConstantUz {

    String START = """
            Assalomu aleykum! Botimizga xush kelibsiz!\s
            Xizmat ko’rsatish tilini tanlang:
            """;
    String BUTTON = "O'zbekcha \uD83C\uDDFA\uD83C\uDDFF";
    String CONTACT_BUTTON = "Raqamni jo'natish \uD83D\uDCDE";
    String CONTACT = """
            Telefon raqamingizni kiriting
            \s
            <RAQAMNI JO'NATISH> tugmasi yordamida raqamni yuboring""";
    String ABOUT_US_BUTTON = "Biz haqimizda \uD83D\uDD0E";
    String SERVICES_BUTTON = "Xizmatlar \uD83D\uDEE0";
    String EVENTS_BUTTON = "Tadbirlar \uD83D\uDCBB";
    String SETTINGS_BUTTON = "Sozlamalar ⚙";
    String VACANCY_BUTTON = "Vakansiya \uD83D\uDC68\uD83C\uDFFB\u200D\uD83D\uDCBB";
    String MENU = "Asosiy menyu : ";
    String ABOUT_US = """
            <b>Avantage</b>\s
            \s
            \uD83C\uDF10 <a href="https://cio.teda.uz/"> cio.teda.uz</a>
            ☎ <b>+998 (93) 159 25 58  +998 (97) 716 63 44</b>
            \uD83D\uDCE7 <b>info@avantage.events</b>
            \uD83D\uDCCD <b>Toshkent shahar, Mirzo Ulug`bek tuman, Mirzo lug`bek shoh ko`chasi 87</b>
            \uD83C\uDF10 <a href="https://cio.uz/">CIO.uz</a>
            <b>Menejirimizga savolingizni qoldiring va </b>
            <b> menejerimiz sizga imkon qadar tezroq javob beradi.</b>
            \uD83D\uDC64 <b> Manager :info@cio.uz</b>\s""";
//            \uD83C\uDFE6<b>Х/р: 20208000800895476001, РАКБ «Davr Bank» Mirzo Ulug`bek f-li Toshkent shahar</b>\s
//            <b>МФО: 01072 ИНН: 305626506  ОКЭД: 82990</b>\s""";

    String VACANCY = "Hozircha vakansiya yo`q \n" ;
    //            "\uD83D\uDC64 Manager : @Proekt_Manager\n";
    String LANGUAGE = "Tilni o'zgartirish \uD83C\uDDF7\uD83C\uDDFA/\uD83C\uDDFA\uD83C\uDDFF/\uD83C\uDDEC\uD83C\uDDE7";
    String PHONE = "Raqamni o'zgartirish \uD83D\uDCDE";
    String BACK = "Orqaga ⬅";
    String CHOOSE = "Tanlang: ";
    String EDITED = "Muvafaqiyatli o'zgartirildi \uD83C\uDD97";
    String CHOOSE_LANGUAGE = "Iltimos tilni tanlang:";
    String LANGUAGE_ICON = "UZB \uD83C\uDDFA\uD83C\uDDFF";
    String OK = "\uD83C\uDD97";
    String IN_DETAIL = "Batafsil\uD83D\uDD0E";
    String REQUEST = "So'rov\uD83D\uDCCC";
    //    String RESPONSE_FOR_REQUEST = "Murojaatingiz muvafaqiyatli qabul qilindi.✅\n" +
//            "Tez orada menejerimiz aloqaga chiqadi.";
    String RESPONSE_FOR_REQUEST = "Murojaatingiz muvafaqiyatli qabul qilindi.✅\n" +
            "";
    String MY_REQUESTS = "Mening Tadbirlarim \uD83C\uDFAF";

    String MY_REQUESTS_EMPTY = "Sizda hali hech qanday murojatlar mavjud emas";
    String SELECT_COUNTRY = "Iltimos o'z davlatingizni qisqa kodni jo'nating \n (Misol: Uzbekistan -> Uz)";
    String ERROR_COUNTRY = "Siz kiritgan malumot bo'yicha hech qanday malumot topilmadi.\nIltimis qaytadan kiriting: ";
    String SELECT_REGION = "Iltimos o'z viloyatingiz yoki shaxringizni tanlang: ";
}
