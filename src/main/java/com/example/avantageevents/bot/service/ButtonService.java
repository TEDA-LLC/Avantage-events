package com.example.avantageevents.bot.service;

import com.example.avantageevents.bot.constant.ConstantEn;
import com.example.avantageevents.bot.constant.ConstantRu;
import com.example.avantageevents.bot.constant.ConstantUz;
import com.example.avantageevents.model.Category;
import com.example.avantageevents.model.Country;
import com.example.avantageevents.model.Product;
import com.example.avantageevents.model.Region;
import com.example.avantageevents.model.enums.Language;
import com.example.avantageevents.repository.CategoryRepository;
import com.example.avantageevents.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Malikov Azizjon  *  01.02.2023  *  22:00   *  AvantageEvents
 */

@Service
@RequiredArgsConstructor
public class ButtonService {

    private final CategoryRepository categoryRepository;
    private final RegionRepository regionRepository;

    public ReplyKeyboardMarkup menuButton(Language language) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        replyKeyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> rowList = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();
        KeyboardButton button1 = new KeyboardButton();
        KeyboardButton button2 = new KeyboardButton();
        KeyboardButton button3 = new KeyboardButton();
        KeyboardButton button4 = new KeyboardButton();
        KeyboardButton button5 = new KeyboardButton();

        if (language.equals(Language.UZB)) {
            button.setText(ConstantUz.SERVICES_BUTTON);
            button1.setText(ConstantUz.EVENTS_BUTTON);
            button5.setText(ConstantUz.QR_CODE_BUTTON);

            button3.setText(ConstantUz.SETTINGS_BUTTON);
            button4.setText(ConstantUz.ABOUT_US_BUTTON);
            button2.setText(ConstantUz.MY_REQUESTS);
        } else if (language.equals(Language.ENG)) {
            button.setText(ConstantEn.SERVICES_BUTTON);
            button1.setText(ConstantEn.EVENTS_BUTTON);
            button5.setText(ConstantEn.QR_CODE_BUTTON);

            button3.setText(ConstantEn.SETTINGS_BUTTON);
            button4.setText(ConstantEn.ABOUT_US_BUTTON);
            button2.setText(ConstantEn.MY_REQUESTS);
        } else {
            button.setText(ConstantRu.SERVICES_BUTTON);
            button1.setText(ConstantRu.EVENTS_BUTTON);
            button5.setText(ConstantRu.QR_CODE_BUTTON);

            button3.setText(ConstantRu.SETTINGS_BUTTON);
            button4.setText(ConstantRu.ABOUT_US_BUTTON);
            button2.setText(ConstantRu.MY_REQUESTS);
        }
        row.add(button);
        row.add(button1);
        row.add(button5);
        row1.add(button3);
        row1.add(button4);
        row1.add(button2);
        rowList.add(row);
        rowList.add(row1);
        replyKeyboardMarkup.setKeyboard(rowList);

        return replyKeyboardMarkup;
    }

    public ReplyKeyboardMarkup settingsMenu(Language language) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        replyKeyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> rowList = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardButton languageButton = new KeyboardButton();
        KeyboardButton number = new KeyboardButton();
        KeyboardButton back = new KeyboardButton();

        number.setRequestContact(true);


        if (language.equals(Language.UZB)) {
            languageButton.setText(ConstantUz.LANGUAGE);
            number.setText(ConstantUz.PHONE);
            back.setText(ConstantUz.BACK);
        } else if (language.equals(Language.ENG)) {
            languageButton.setText(ConstantEn.LANGUAGE);
            number.setText(ConstantEn.PHONE);
            back.setText(ConstantEn.BACK);
        } else {
            languageButton.setText(ConstantRu.LANGUAGE);
            number.setText(ConstantRu.PHONE);
            back.setText(ConstantRu.BACK);
        }

        row.add(languageButton);
        row.add(number);
        row1.add(back);
        rowList.add(row);
        rowList.add(row1);
        replyKeyboardMarkup.setKeyboard(rowList);

        return replyKeyboardMarkup;
    }

    public ReplyKeyboardMarkup contact(Language language) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        replyKeyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> rowList = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();
        button.setRequestContact(true);

        if (language.equals(Language.RUS)) {
            button.setText(ConstantRu.CONTACT_BUTTON);
        } else if (language.equals(Language.ENG)) {
            button.setText(ConstantEn.CONTACT_BUTTON);
        } else button.setText(ConstantUz.CONTACT_BUTTON);

        row.add(button);
        rowList.add(row);
        replyKeyboardMarkup.setKeyboard(rowList);

        return replyKeyboardMarkup;
    }

    public ReplyKeyboardMarkup language() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        replyKeyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> rowList = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardButton rus = new KeyboardButton();
        KeyboardButton eng = new KeyboardButton();
        KeyboardButton uzb = new KeyboardButton();
        rus.setText(ConstantRu.BUTTON);
        eng.setText(ConstantEn.BUTTON);
        uzb.setText(ConstantUz.BUTTON);
        row.add(rus);
        row.add(eng);
        row.add(uzb);
        rowList.add(row);
        replyKeyboardMarkup.setKeyboard(rowList);

        return replyKeyboardMarkup;
    }

    public ReplyKeyboardMarkup editLanguage() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        replyKeyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> rowList = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardButton rus = new KeyboardButton();
        KeyboardButton eng = new KeyboardButton();
        KeyboardButton uzb = new KeyboardButton();
        rus.setText(ConstantRu.LANGUAGE_ICON);
        eng.setText(ConstantEn.LANGUAGE_ICON);
        uzb.setText(ConstantUz.LANGUAGE_ICON);
        row.add(rus);
        row.add(eng);
        row.add(uzb);
        rowList.add(row);
        replyKeyboardMarkup.setKeyboard(rowList);

        return replyKeyboardMarkup;
    }

    public ReplyKeyboardMarkup categories(Language language) {

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        replyKeyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> rowList = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();

        KeyboardButton backButton = new KeyboardButton();

        for (Category category : categoryRepository.findAll()) {
            KeyboardButton button = new KeyboardButton();
            if (language.equals(Language.UZB)) {
                button.setText(category.getNameUz());
                backButton.setText(ConstantUz.BACK);
            } else if (language.equals(Language.ENG)) {
                button.setText(category.getNameEn());
                backButton.setText(ConstantEn.BACK);
            } else {
                button.setText(category.getNameRu());
                backButton.setText(ConstantRu.BACK);
            }
            row1.add(button);
        }
        row2.add(backButton);

        rowList.add(row1);
        rowList.add(row2);
        replyKeyboardMarkup.setKeyboard(rowList);

        return replyKeyboardMarkup;

    }

    public InlineKeyboardMarkup products(List<Product> products, Language language) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();

        for (Product product : products) {
            if (language.equals(Language.UZB)) {
                buttons.add(Collections.singletonList(
                        InlineKeyboardButton.builder().text(product.getNameUz()).callbackData(String.valueOf(product.getId())).build()));
            } else if (language.equals(Language.ENG)) {
                buttons.add(Collections.singletonList(
                        InlineKeyboardButton.builder().text(product.getNameEn()).callbackData(String.valueOf(product.getId())).build()));
            } else {
                buttons.add(Collections.singletonList(
                        InlineKeyboardButton.builder().text(product.getNameRu()).callbackData(String.valueOf(product.getId())).build()));
            }
        }
        if (language.equals(Language.UZB)) {
            buttons.add(Collections.singletonList(InlineKeyboardButton.builder().text(ConstantUz.BACK).callbackData("$back").build()));
        } else if (language.equals(Language.ENG)) {
            buttons.add(Collections.singletonList(InlineKeyboardButton.builder().text(ConstantEn.BACK).callbackData("$back").build()));
        } else {
            buttons.add(Collections.singletonList(InlineKeyboardButton.builder().text(ConstantRu.BACK).callbackData("$back").build()));
        }
        inlineKeyboardMarkup.setKeyboard(buttons);

        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup aboutProduct(Language language, Product product) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();

        if (language.equals(Language.UZB)) {
            buttons.add(Arrays.asList(
                    InlineKeyboardButton.builder().text(ConstantUz.IN_DETAIL).url("https://cio.teda.uz/").build(),
                    InlineKeyboardButton.builder().text(ConstantUz.REQUEST).callbackData("$request" + product.getId()).build()));
            buttons.add(Collections.singletonList(InlineKeyboardButton.builder().text(ConstantUz.BACK).callbackData("$back" + product.getCategory().getId()).build()));
        } else if (language.equals(Language.ENG)) {
            buttons.add(Arrays.asList(
                    InlineKeyboardButton.builder().text(ConstantEn.IN_DETAIL).url("https://cio.teda.uz/").build(),
                    InlineKeyboardButton.builder().text(ConstantEn.REQUEST).callbackData("$request" + product.getId()).build()));
            buttons.add(Collections.singletonList(InlineKeyboardButton.builder().text(ConstantEn.BACK).callbackData("$back" + product.getCategory().getId()).build()));
        } else {
            buttons.add(Arrays.asList(
                    InlineKeyboardButton.builder().text(ConstantRu.IN_DETAIL).url("https://cio.teda.uz/").build(),
                    InlineKeyboardButton.builder().text(ConstantRu.REQUEST).callbackData("$request" + product.getId()).build()));
            buttons.add(Collections.singletonList(InlineKeyboardButton.builder().text(ConstantRu.BACK).callbackData("$back" + product.getCategory().getId()).build()));
        }

        inlineKeyboardMarkup.setKeyboard(buttons);

        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup regions(Country country) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        List<Region> regionList = regionRepository.findAllByCountry_Id(country.getId());
        for (Region region : regionList) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(region.getName());
            button.setCallbackData("$region" + region.getId());
            buttons.add(List.of(button));
        }
        inlineKeyboardMarkup.setKeyboard(buttons);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup company(Language language) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        if (language.equals(Language.ENG)) {
            button.setText(ConstantEn.ABOUT_COMPANY_IF_NOT_BUTTON);
        } else if (language.equals(Language.RUS)) {
            button.setText(ConstantRu.ABOUT_COMPANY_IF_NOT_BUTTON);
        } else {
            button.setText(ConstantUz.ABOUT_COMPANY_IF_NOT_BUTTON);
        }
        button.setCallbackData("$no");
        buttons.add(List.of(button));
        inlineKeyboardMarkup.setKeyboard(buttons);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup howKnow(Language language) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        InlineKeyboardButton button3 = new InlineKeyboardButton();
        InlineKeyboardButton button4 = new InlineKeyboardButton();
        if (language.equals(Language.ENG)) {
            button.setText(ConstantEn.TV_KNOW_BUTTON);
            button1.setText(ConstantEn.INTERNET_KNOW_BUTTON);
            button2.setText(ConstantEn.ADVERTISING_KNOW_BUTTON);
            button3.setText(ConstantEn.EMAIL_KNOW_BUTTON);
            button4.setText(ConstantEn.ANOTHER_KNOW_BUTTON);
        } else if (language.equals(Language.RUS)) {
            button.setText(ConstantRu.TV_KNOW_BUTTON);
            button1.setText(ConstantRu.INTERNET_KNOW_BUTTON);
            button2.setText(ConstantRu.ADVERTISING_KNOW_BUTTON);
            button3.setText(ConstantRu.EMAIL_KNOW_BUTTON);
            button4.setText(ConstantRu.ANOTHER_KNOW_BUTTON);
        } else {
            button.setText(ConstantUz.TV_KNOW_BUTTON);
            button1.setText(ConstantUz.INTERNET_KNOW_BUTTON);
            button2.setText(ConstantUz.ADVERTISING_KNOW_BUTTON);
            button3.setText(ConstantUz.EMAIL_KNOW_BUTTON);
            button4.setText(ConstantUz.ANOTHER_KNOW_BUTTON);
        }
        button.setCallbackData("$" + ConstantEn.TV_KNOW_BUTTON);
        buttons.add(List.of(button));
        button1.setCallbackData("$" + ConstantEn.INTERNET_KNOW_BUTTON);
        buttons.add(List.of(button1));
        button2.setCallbackData("$" + ConstantEn.ADVERTISING_KNOW_BUTTON);
        buttons.add(List.of(button2));
        button3.setCallbackData("$" + ConstantEn.EMAIL_KNOW_BUTTON);
        buttons.add(List.of(button3));
        button4.setCallbackData("$" + ConstantEn.ANOTHER_KNOW_BUTTON);
        buttons.add(List.of(button4));
        inlineKeyboardMarkup.setKeyboard(buttons);
        return inlineKeyboardMarkup;
    }
}

