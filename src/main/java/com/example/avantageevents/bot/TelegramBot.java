package com.example.avantageevents.bot;

import com.example.avantageevents.bot.constant.ConstantEn;
import com.example.avantageevents.bot.constant.ConstantRu;
import com.example.avantageevents.bot.constant.ConstantUz;
import com.example.avantageevents.bot.service.BotService;
import com.example.avantageevents.model.Address;
import com.example.avantageevents.model.Department;
import com.example.avantageevents.model.Product;
import com.example.avantageevents.model.User;
import com.example.avantageevents.model.enums.Language;
import com.example.avantageevents.model.enums.RegisteredType;
import com.example.avantageevents.model.enums.State;
import com.example.avantageevents.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author Malikov Azizjon  *  01.02.2023  *  21:40   *  AvantageEvents
 */

@Component
@RequiredArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {

    @Value("${telegram.bot.username}")
    private String userName;
    @Value("${telegram.bot.token}")
    private String botToken;
    @Value("${company.department.id}")
    private Long departmentId;
    private final BotService botService;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final DepartmentRepository departmentRepository;
    private final RegionRepository regionRepository;
    private final AddressRepository addressRepository;

    @Override
    public String getBotUsername() {
        return userName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                User currentUser;
                if (update.hasMessage()) {
                    Optional<Department> departmentOptional = departmentRepository.findById(departmentId);
                    Message message = update.getMessage();
                    String chatId = String.valueOf(message.getChatId());
                    Optional<User> optionalUser = userRepository.findByDepartment_IdAndChatId(departmentId, chatId);
                    if (message.hasText()) {
                        if (message.getText().equals("/start")) {
                            if (optionalUser.isPresent()) {
                                currentUser = optionalUser.get();
                                currentUser.setState(State.START);
                                currentUser.setFullName(update.getMessage().getFrom().getFirstName());
                            } else {
                                currentUser = new User();
                                currentUser.setDepartment(departmentOptional.get());
                                currentUser.setChatId(String.valueOf(update.getMessage().getChatId()));
                                currentUser.setRegisteredType(RegisteredType.BOT);
                                currentUser.setFullName(message.getFrom().getFirstName());
                                currentUser.setUsername(message.getFrom().getUserName());
                                currentUser.setState(State.START);
                            }
                            currentUser.setLastOperationTime(LocalDateTime.now());
                            userRepository.save(currentUser);
                            execute(botService.start(chatId));
                        } else if (message.getText().equals(ConstantUz.BUTTON)) {
                            currentUser = optionalUser.get();
                            currentUser.setLanguage(Language.UZB);
                            currentUser.setLastOperationTime(LocalDateTime.now());
                            userRepository.save(currentUser);
                            execute(botService.language(chatId, Language.UZB));
                        } else if (message.getText().equals(ConstantRu.BUTTON)) {
                            currentUser = optionalUser.get();
                            currentUser.setLanguage(Language.RUS);
                            currentUser.setLastOperationTime(LocalDateTime.now());
                            userRepository.save(currentUser);
                            execute(botService.language(chatId, Language.RUS));
                        } else if (message.getText().equals(ConstantEn.BUTTON)) {
                            currentUser = optionalUser.get();
                            currentUser.setLanguage(Language.ENG);
                            currentUser.setLastOperationTime(LocalDateTime.now());
                            userRepository.save(currentUser);
                            execute(botService.language(chatId, Language.ENG));
                        } else {
                            currentUser = optionalUser.get();
                            switch (currentUser.getState()) {
                                case COMPANY -> {
                                    currentUser.setState(State.HOW_KNOW);
                                    currentUser.setLastOperationTime(LocalDateTime.now());
                                    currentUser.setCompany(message.getText());
                                    userRepository.save(currentUser);
                                    execute(botService.howKnow(currentUser));
                                }
                                case COUNTRY -> {
//                                    currentUser.setState(State.CONTACT);
                                    currentUser.setLastOperationTime(LocalDateTime.now());
                                    userRepository.save(currentUser);
                                    execute(botService.deleteMessage(chatId, update.getMessage().getMessageId() - 1));
                                    SendMessage sendMessage = botService.region(currentUser, update.getMessage());
                                    if (currentUser.getAddress() != null) {
                                        execute(SendMessage.builder().chatId(currentUser.getChatId()).text(currentUser.getAddress().getCountry().getName()).build());
                                    }
                                    execute(sendMessage);
                                }
                                case CONTACT -> {
                                    if (message.getText().equals(ConstantUz.ABOUT_US_BUTTON) || message.getText().equals(ConstantRu.ABOUT_US_BUTTON) || message.getText().equals(ConstantEn.ABOUT_US_BUTTON)) {
                                        currentUser.setLastOperationTime(LocalDateTime.now());
                                        userRepository.save(currentUser);
                                        execute(botService.aboutUs(chatId, currentUser.getLanguage()));
                                    } else if (message.getText().equals(ConstantUz.QR_CODE_BUTTON) || message.getText().equals(ConstantRu.QR_CODE_BUTTON) || message.getText().equals(ConstantEn.QR_CODE_BUTTON)) {
                                        currentUser.setLastOperationTime(LocalDateTime.now());
                                        userRepository.save(currentUser);
                                        execute(botService.qrCode(chatId, currentUser));
                                        execute(botService.menu(chatId, currentUser.getLanguage()));
                                    } else if (message.getText().equals(ConstantUz.MY_REQUESTS) || message.getText().equals(ConstantRu.MY_REQUESTS) || message.getText().equals(ConstantEn.MY_REQUESTS)) {
                                        currentUser.setLastOperationTime(LocalDateTime.now());
                                        userRepository.save(currentUser);
                                        execute(botService.myRequests(chatId, currentUser));
                                        execute(botService.menu(chatId, currentUser.getLanguage()));
                                    } else if (message.getText().equals(ConstantUz.SETTINGS_BUTTON) || message.getText().equals(ConstantRu.SETTINGS_BUTTON) || message.getText().equals(ConstantEn.SETTINGS_BUTTON)) {
                                        currentUser.setState(State.SETTINGS);
                                        currentUser.setLastOperationTime(LocalDateTime.now());
                                        userRepository.save(currentUser);
                                        execute(botService.settings(chatId, currentUser.getLanguage()));
                                    } else if ((message.getText().matches("(" + ConstantUz.EVENTS_BUTTON + "|" + ConstantRu.EVENTS_BUTTON + "|" + ConstantEn.EVENTS_BUTTON + "|" + ConstantUz.SERVICES_BUTTON + "|" + ConstantRu.SERVICES_BUTTON + "|" + ConstantEn.SERVICES_BUTTON + ")"))) {
                                        Long categoryId = botService.getCategoryIdByName(message.getText());
                                        if (categoryId != null) {
                                            execute(botService.products(categoryId, currentUser.getLanguage(), chatId));
                                        } else if (message.getText().equals(ConstantUz.BACK) || message.getText().equals(ConstantRu.BACK) || message.getText().equals(ConstantEn.BACK)) {
                                            currentUser.setState(State.CONTACT);
                                            currentUser.setLastOperationTime(LocalDateTime.now());
                                            userRepository.save(currentUser);
                                            execute(botService.ok(chatId, currentUser.getLanguage()));
                                        }
                                    } else {
                                        botService.storyWriter(currentUser, message);
                                    }
                                }
                                case SETTINGS -> {
                                    if (message.getText().equals(ConstantUz.LANGUAGE) || message.getText().equals(ConstantRu.LANGUAGE) || message.getText().equals(ConstantEn.LANGUAGE)) {
                                        currentUser.setState(State.LANGUAGE);
                                        currentUser.setLastOperationTime(LocalDateTime.now());
                                        userRepository.save(currentUser);
                                        execute(botService.editLanguage(chatId, currentUser.getLanguage()));
                                    } else if (message.getText().equals(ConstantUz.BACK) || message.getText().equals(ConstantRu.BACK) || message.getText().equals(ConstantEn.BACK)) {
                                        currentUser.setState(State.CONTACT);
                                        currentUser.setLastOperationTime(LocalDateTime.now());
                                        userRepository.save(currentUser);
                                        execute(botService.ok(chatId, currentUser.getLanguage()));
                                    } else {
                                        botService.storyWriter(currentUser, message);
                                    }
                                }
                                case LANGUAGE -> {
                                    if (message.getText().equals(ConstantUz.LANGUAGE_ICON)) {
                                        currentUser.setState(State.SETTINGS);
                                        currentUser.setLanguage(Language.UZB);
                                        currentUser.setLastOperationTime(LocalDateTime.now());
                                        userRepository.save(currentUser);
                                    } else if (message.getText().equals(ConstantEn.LANGUAGE_ICON)) {
                                        currentUser.setState(State.SETTINGS);
                                        currentUser.setLanguage(Language.ENG);
                                        currentUser.setLastOperationTime(LocalDateTime.now());
                                        userRepository.save(currentUser);
                                    } else if (message.getText().equals(ConstantRu.LANGUAGE_ICON)) {
                                        currentUser.setState(State.SETTINGS);
                                        currentUser.setLanguage(Language.RUS);
                                        currentUser.setLastOperationTime(LocalDateTime.now());
                                        userRepository.save(currentUser);
                                    } else {
                                        botService.storyWriter(currentUser, message);
                                    }
                                    execute(botService.edited(chatId, currentUser.getLanguage()));
                                }
                                default -> botService.storyWriter(currentUser, message);
                            }
                        }
                    } else if (message.hasContact()) {
                        User user = optionalUser.get();
                        switch (user.getState()) {
                            case START -> {
                                String phoneNumber = message.getContact().getPhoneNumber();
                                if (!phoneNumber.startsWith("+")) {
                                    phoneNumber = "+" + phoneNumber;
                                }
                                Optional<User> byPhone = userRepository.findByPhoneAndDepartment_Id(phoneNumber, departmentId);
                                user.setPhone(message.getContact().getPhoneNumber());
                                user.setState(State.COUNTRY);
                                user.setLastOperationTime(LocalDateTime.now());
                                if (byPhone.isPresent() && !byPhone.get().getId().equals(user.getId())) {
                                    User user1 = byPhone.get();
                                    user1.setState(user.getState());
                                    user1.setPhone(phoneNumber);
                                    user1.setCount(user1.getCount() + user.getCount());
                                    user1.setLastOperationTime(LocalDateTime.now());
                                    user1.setLanguage(user.getLanguage());
                                    user1.setChatId(user.getChatId());
                                    user1.setUsername(user.getUsername());
                                    user1.setDepartment(user.getDepartment());
                                    userRepository.save(user1);
                                    userRepository.delete(user);
                                    execute(botService.country(user1));
                                } else {
                                    userRepository.save(user);
                                    execute(botService.country(user));
                                }
//                                user.setState(State.REGION);
//                                user.setLastOperationTime(LocalDateTime.now());
//                                userRepository.save(user);
//                                execute(botService.country(user));
//                                execute(botService.menu(chatId, user.getLanguage()));
                            }
                            case SETTINGS -> {
                                user.setPhone(message.getContact().getPhoneNumber());
                                user.setLastOperationTime(LocalDateTime.now());
                                userRepository.save(user);
                                execute(botService.edited(chatId, user.getLanguage()));
                            }
//                            case COUNTRY -> {
//                                user.setState(State.REGION);
//                                user.setLastOperationTime(LocalDateTime.now());
//                                userRepository.save(user);
//                                execute(botService.country(user));
//                            }
                        }
                    }
                } else if (update.hasCallbackQuery()) {
                    CallbackQuery callbackQuery = update.getCallbackQuery();
                    String chatId = String.valueOf(callbackQuery.getMessage().getChatId());
                    Optional<User> optionalUser = userRepository.findByDepartment_IdAndChatId(departmentId, chatId);
                    currentUser = optionalUser.get();
                    switch (currentUser.getState()) {
                        case CONTACT -> {
                            if (callbackQuery.getData().startsWith("$back")) {
                                execute(botService.deleteMessage(chatId, callbackQuery.getMessage().getMessageId()));
                                execute(botService.menu(chatId, currentUser.getLanguage()));
                            } else {
                                currentUser.setState(State.PRODUCT);
                                currentUser.setLastOperationTime(LocalDateTime.now());
                                userRepository.save(currentUser);
                                execute(botService.deleteMessage(chatId, callbackQuery.getMessage().getMessageId()));
                                execute(botService.getProduct(update, currentUser));
                            }
                        }
                        case PRODUCT -> {
                            if (callbackQuery.getData().startsWith("$back")) {
                                currentUser.setState(State.CONTACT);
                                currentUser.setLastOperationTime(LocalDateTime.now());
                                userRepository.save(currentUser);
                                execute(botService.deleteMessage(chatId, callbackQuery.getMessage().getMessageId()));
                                execute(botService.backToProducts(update, chatId, currentUser.getLanguage()));
                            } else if (callbackQuery.getData().startsWith("$request")) {
                                currentUser.setLastOperationTime(LocalDateTime.now());
                                execute(botService.saveRequest(update, currentUser));
                                Long productId = Long.valueOf(update.getCallbackQuery().getData().substring(8));
                                Optional<Product> productOptional = productRepository.findById(productId);
                                if (productOptional.isPresent() && productOptional.get().getAddress() != null) {
                                    Address address = productOptional.get().getAddress();
                                    if (address.getLongitude() != null && address.getLatitude() != null) {
                                        execute(botService.getLocation(update, currentUser));
                                    }
                                }
                                currentUser.setState(State.CONTACT);
                                userRepository.save(currentUser);
                                execute(botService.menu(chatId, currentUser.getLanguage()));
                            }
                        }
                        case REGION -> {
                            currentUser.setState(State.COMPANY);
                            currentUser.setLastOperationTime(LocalDateTime.now());
                            Long regionId = Long.valueOf(update.getCallbackQuery().getData().substring(7));
                            Address address = new Address();
                            if (currentUser.getAddress() != null)
                                address = currentUser.getAddress();
                            address.setRegion(regionRepository.findById(regionId).get());
                            currentUser.setAddress(addressRepository.save(address));
                            currentUser = userRepository.save(currentUser);
                            execute(botService.deleteMessage(chatId, callbackQuery.getMessage().getMessageId()));
//                            execute(botService.menu(currentUser.getChatId(), currentUser.getLanguage()));
                            execute(botService.company(currentUser));
                        }
                        case COMPANY -> {
                            currentUser.setState(State.HOW_KNOW);
                            currentUser.setLastOperationTime(LocalDateTime.now());
                            currentUser = userRepository.save(currentUser);
                            execute(botService.howKnow(currentUser));
//                            execute(botService.menu(currentUser.getChatId(), currentUser.getLanguage()));
                        }
                        case HOW_KNOW -> {
                            currentUser.setState(State.CONTACT);
                            currentUser.setLastOperationTime(LocalDateTime.now());
                            currentUser.setKnow(callbackQuery.getData().substring(1));
                            currentUser = userRepository.save(currentUser);
                            execute(botService.menu(currentUser.getChatId(), currentUser.getLanguage()));
                        }
                    }
                }
            }
        }).start();
    }

}
