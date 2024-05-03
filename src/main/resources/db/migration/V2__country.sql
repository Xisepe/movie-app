drop table if exists countries;

create table countries
(
    id      int primary key not null,
    alpha_2 varchar(2)      not null,
    alpha_3 varchar(3)      not null,
    name    varchar(75)     not null
);

create index idx_countries_name on countries (lower(name));

insert into countries (id, alpha_2, alpha_3, name)
values (36, 'au', 'aus', 'Австралия'),
       (40, 'at', 'aut', 'Австрия'),
       (31, 'az', 'aze', 'Азербайджан'),
       (8, 'al', 'alb', 'Албания'),
       (12, 'dz', 'dza', 'Алжир'),
       (24, 'ao', 'ago', 'Ангола'),
       (20, 'ad', 'and', 'Андорра'),
       (28, 'ag', 'atg', 'Антигуа и Барбуда'),
       (32, 'ar', 'arg', 'Аргентина'),
       (51, 'am', 'arm', 'Армения'),
       (4, 'af', 'afg', 'Афганистан'),
       (44, 'bs', 'bhs', 'Багамские Острова'),
       (50, 'bd', 'bgd', 'Бангладеш'),
       (52, 'bb', 'brb', 'Барбадос'),
       (48, 'bh', 'bhr', 'Бахрейн'),
       (84, 'bz', 'blz', 'Белиз'),
       (112, 'by', 'blr', 'Беларусь'),
       (56, 'be', 'bel', 'Бельгия'),
       (204, 'bj', 'ben', 'Бенин'),
       (100, 'bg', 'bgr', 'Болгария'),
       (68, 'bo', 'bol', 'Боливия'),
       (70, 'ba', 'bih', 'Босния и Герцеговина'),
       (72, 'bw', 'bwa', 'Ботсвана'),
       (76, 'br', 'bra', 'Бразилия'),
       (96, 'bn', 'brn', 'Бруней'),
       (854, 'bf', 'bfa', 'Буркина-Фасо'),
       (108, 'bi', 'bdi', 'Бурунди'),
       (64, 'bt', 'btn', 'Бутан'),
       (548, 'vu', 'vut', 'Вануату'),
       (826, 'gb', 'gbr', 'Великобритания'),
       (348, 'hu', 'hun', 'Венгрия'),
       (862, 've', 'ven', 'Венесуэла'),
       (626, 'tl', 'tls', 'Восточный Тимор'),
       (704, 'vn', 'vnm', 'Вьетнам'),
       (266, 'ga', 'gab', 'Габон'),
       (332, 'ht', 'hti', 'Гаити'),
       (328, 'gy', 'guy', 'Гайана'),
       (270, 'gm', 'gmb', 'Гамбия'),
       (288, 'gh', 'gha', 'Гана'),
       (320, 'gt', 'gtm', 'Гватемала'),
       (324, 'gn', 'gin', 'Гвинея'),
       (624, 'gw', 'gnb', 'Гвинея-Бисау'),
       (276, 'de', 'deu', 'Германия'),
       (340, 'hn', 'hnd', 'Гондурас'),
       (308, 'gd', 'grd', 'Гренада'),
       (300, 'gr', 'grc', 'Греция'),
       (268, 'ge', 'geo', 'Грузия'),
       (208, 'dk', 'dnk', 'Дания'),
       (262, 'dj', 'dji', 'Джибути'),
       (212, 'dm', 'dma', 'Доминика'),
       (214, 'do', 'dom', 'Доминиканская Республика'),
       (180, 'cd', 'cod', 'ДР Конго'),
       (818, 'eg', 'egy', 'Египет'),
       (894, 'zm', 'zmb', 'Замбия'),
       (716, 'zw', 'zwe', 'Зимбабве'),
       (376, 'il', 'isr', 'Израиль'),
       (356, 'in', 'ind', 'Индия'),
       (360, 'id', 'idn', 'Индонезия'),
       (400, 'jo', 'jor', 'Иордания'),
       (368, 'iq', 'irq', 'Ирак'),
       (364, 'ir', 'irn', 'Иран'),
       (372, 'ie', 'irl', 'Ирландия'),
       (352, 'is', 'isl', 'Исландия'),
       (724, 'es', 'esp', 'Испания'),
       (380, 'it', 'ita', 'Италия'),
       (887, 'ye', 'yem', 'Йемен'),
       (132, 'cv', 'cpv', 'Кабо-Верде'),
       (398, 'kz', 'kaz', 'Казахстан'),
       (116, 'kh', 'khm', 'Камбоджа'),
       (120, 'cm', 'cmr', 'Камерун'),
       (124, 'ca', 'can', 'Канада'),
       (634, 'qa', 'qat', 'Катар'),
       (404, 'ke', 'ken', 'Кения'),
       (196, 'cy', 'cyp', 'Кипр'),
       (417, 'kg', 'kgz', 'Кыргызстан'),
       (296, 'ki', 'kir', 'Кирибати'),
       (408, 'kp', 'prk', 'КНДР (Корейская Народно-Демократическая Республика)'),
       (156, 'cn', 'chn', 'Китай (Китайская Народная Республика)'),
       (170, 'co', 'col', 'Колумбия'),
       (174, 'km', 'com', 'Коморы'),
       (188, 'cr', 'cri', 'Коста-Рика'),
       (384, 'ci', 'civ', 'Кот-д’Ивуар'),
       (192, 'cu', 'cub', 'Куба'),
       (414, 'kw', 'kwt', 'Кувейт'),
       (418, 'la', 'lao', 'Лаос'),
       (428, 'lv', 'lva', 'Латвия'),
       (426, 'ls', 'lso', 'Лесото'),
       (430, 'lr', 'lbr', 'Либерия'),
       (422, 'lb', 'lbn', 'Ливан'),
       (434, 'ly', 'lby', 'Ливия'),
       (440, 'lt', 'ltu', 'Литва'),
       (438, 'li', 'lie', 'Лихтенштейн'),
       (442, 'lu', 'lux', 'Люксембург'),
       (480, 'mu', 'mus', 'Маврикий'),
       (478, 'mr', 'mrt', 'Мавритания'),
       (450, 'mg', 'mdg', 'Мадагаскар'),
       (807, 'mk', 'mkd', 'Северная Македония'),
       (454, 'mw', 'mwi', 'Малави'),
       (458, 'my', 'mys', 'Малайзия'),
       (466, 'ml', 'mli', 'Мали'),
       (462, 'mv', 'mdv', 'Мальдивы'),
       (470, 'mt', 'mlt', 'Мальта'),
       (504, 'ma', 'mar', 'Марокко'),
       (584, 'mh', 'mhl', 'Маршалловы Острова'),
       (484, 'mx', 'mex', 'Мексика'),
       (583, 'fm', 'fsm', 'Микронезия'),
       (508, 'mz', 'moz', 'Мозамбик'),
       (498, 'md', 'mda', 'Молдавия'),
       (492, 'mc', 'mco', 'Монако'),
       (496, 'mn', 'mng', 'Монголия'),
       (104, 'mm', 'mmr', 'Мьянма'),
       (516, 'na', 'nam', 'Намибия'),
       (520, 'nr', 'nru', 'Науру'),
       (524, 'np', 'npl', 'Непал'),
       (562, 'ne', 'ner', 'Нигер'),
       (566, 'ng', 'nga', 'Нигерия'),
       (528, 'nl', 'nld', 'Нидерланды'),
       (558, 'ni', 'nic', 'Никарагуа'),
       (554, 'nz', 'nzl', 'Новая Зеландия'),
       (578, 'no', 'nor', 'Норвегия'),
       (784, 'ae', 'are', 'ОАЭ'),
       (512, 'om', 'omn', 'Оман'),
       (586, 'pk', 'pak', 'Пакистан'),
       (585, 'pw', 'plw', 'Палау'),
       (591, 'pa', 'pan', 'Панама'),
       (598, 'pg', 'png', 'Папуа — Новая Гвинея'),
       (600, 'py', 'pry', 'Парагвай'),
       (604, 'pe', 'per', 'Перу'),
       (616, 'pl', 'pol', 'Польша'),
       (620, 'pt', 'prt', 'Португалия'),
       (178, 'cg', 'cog', 'Республика Конго'),
       (410, 'kr', 'kor', 'Республика Корея'),
       (643, 'ru', 'rus', 'Россия'),
       (646, 'rw', 'rwa', 'Руанда'),
       (642, 'ro', 'rou', 'Румыния'),
       (222, 'sv', 'slv', 'Сальвадор'),
       (882, 'ws', 'wsm', 'Самоа'),
       (674, 'sm', 'smr', 'Сан-Марино'),
       (678, 'st', 'stp', 'Сан-Томе и Принсипи'),
       (682, 'sa', 'sau', 'Саудовская Аравия'),
       (748, 'sz', 'swz', 'Эсватини'),
       (690, 'sc', 'syc', 'Сейшельские Острова'),
       (686, 'sn', 'sen', 'Сенегал'),
       (670, 'vc', 'vct', 'Сент-Винсент и Гренадины'),
       (659, 'kn', 'kna', 'Сент-Китс и Невис'),
       (662, 'lc', 'lca', 'Сент-Люсия'),
       (688, 'rs', 'srb', 'Сербия'),
       (702, 'sg', 'sgp', 'Сингапур'),
       (760, 'sy', 'syr', 'Сирия'),
       (703, 'sk', 'svk', 'Словакия'),
       (705, 'si', 'svn', 'Словения'),
       (90, 'sb', 'slb', 'Соломоновы Острова'),
       (706, 'so', 'som', 'Сомали'),
       (729, 'sd', 'sdn', 'Судан'),
       (740, 'sr', 'sur', 'Суринам'),
       (840, 'us', 'usa', 'США'),
       (694, 'sl', 'sle', 'Сьерра-Леоне'),
       (762, 'tj', 'tjk', 'Таджикистан'),
       (764, 'th', 'tha', 'Таиланд'),
       (834, 'tz', 'tza', 'Танзания'),
       (768, 'tg', 'tgo', 'Того'),
       (776, 'to', 'ton', 'Тонга'),
       (780, 'tt', 'tto', 'Тринидад и Тобаго'),
       (798, 'tv', 'tuv', 'Тувалу'),
       (788, 'tn', 'tun', 'Тунис'),
       (795, 'tm', 'tkm', 'Туркменистан'),
       (792, 'tr', 'tur', 'Турция'),
       (800, 'ug', 'uga', 'Уганда'),
       (860, 'uz', 'uzb', 'Узбекистан'),
       (804, 'ua', 'ukr', 'Украина'),
       (858, 'uy', 'ury', 'Уругвай'),
       (242, 'fj', 'fji', 'Фиджи'),
       (608, 'ph', 'phl', 'Филиппины'),
       (246, 'fi', 'fin', 'Финляндия'),
       (250, 'fr', 'fra', 'Франция'),
       (191, 'hr', 'hrv', 'Хорватия'),
       (140, 'cf', 'caf', 'ЦАР'),
       (148, 'td', 'tcd', 'Чад'),
       (499, 'me', 'mne', 'Черногория'),
       (203, 'cz', 'cze', 'Чехия'),
       (152, 'cl', 'chl', 'Чили'),
       (756, 'ch', 'che', 'Швейцария'),
       (752, 'se', 'swe', 'Швеция'),
       (144, 'lk', 'lka', 'Шри-Ланка'),
       (218, 'ec', 'ecu', 'Эквадор'),
       (226, 'gq', 'gnq', 'Экваториальная Гвинея'),
       (232, 'er', 'eri', 'Эритрея'),
       (233, 'ee', 'est', 'Эстония'),
       (231, 'et', 'eth', 'Эфиопия'),
       (710, 'za', 'zaf', 'ЮАР'),
       (728, 'ss', 'ssd', 'Южный Судан'),
       (388, 'jm', 'jam', 'Ямайка'),
       (392, 'jp', 'jpn', 'Япония')