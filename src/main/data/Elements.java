/*
 * PSE - Periodic System of Elements (Learn and Information Application)
 * Copyright (C) 2025 Jim Feser
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 * Contact:
 *  Github: https://github.com/jimfeserHTW
 *
 * If this program interacts with users remotely through a computer network,
 * it must provide a way for users to get its source code, for example by
 * offering a “Source” link in the user interface (see section 13 of the AGPL).
 */

package main.data;

import java.util.Map;

/**
 * Elements class contains static instances of ChemicalElement representing
 * the first 20 elements of the periodic table, along with their properties.
 * This class is designed
 */
public class Elements {

    /**
     * Contructor is private to prevent instantiation.
     */
    private Elements(){
    }

    private final static ChemicalElement HYDROGEN = new ChemicalElement(
        (byte) 1, 
        "H",
        Map.ofEntries(
            Map.entry("de", "Wasserstoff"),
            Map.entry("en", "Hydrogen"),
            Map.entry("fr", "Hydrogène"),
            Map.entry("zh", "氢"),
            Map.entry("ru", "Водород"),
            Map.entry("jp", "水素")
        ),
        1.008,
        2.20,
        "1s^1",
        14,      // Schmelzpunkt  -259 °C + 273.15 = 14.15 K (gerundet)
        20,      // Siedepunkt  -253 °C + 273.15 = 20.15 K (gerundet)
        new byte[] {1, -1},
        0.00,
        Map.ofEntries(
            Map.entry("de", "Nichtmetall"),
            Map.entry("en", "Nonmetal"),
            Map.entry("fr", "Non-métal"),
            Map.entry("zh", "非金属"),
            Map.entry("ru", "неметалл"),
            Map.entry("jp", "非金属")
        )
    );

    private final static ChemicalElement HELIUM = new ChemicalElement(
        (byte) 2,
        "He",
        Map.ofEntries(
            Map.entry("de", "Helium"),
            Map.entry("en", "Helium"),
            Map.entry("fr", "Hélium"),
            Map.entry("zh", "氦"),
            Map.entry("ru", "Гелий"),
            Map.entry("jp", "ヘリウム")
        ),
        4.0026,
        Double.NaN,       // Elektronegativität nicht definiert
        "1s^2",
        Integer.MIN_VALUE, // Schmelzpunkt nicht definiert (Helium schmilzt nur unter Druck)
        4,                // Siedepunkt in Kelvin
        new byte[]{},      // Keine Oxidationszahlen bekannt
        Double.NaN,       // Standardelektrodenpotential nicht definiert
        Map.ofEntries(
            Map.entry("de", "Edelgas"),
            Map.entry("en", "Noble gas"),
            Map.entry("fr", "Gaz noble"),
            Map.entry("zh", "惰性气体"),
            Map.entry("ru", "благородный газ"),
            Map.entry("jp", "希ガス")
        )
    );

    private final static ChemicalElement LITHIUM = new ChemicalElement(
        (byte) 3,
        "Li",
        Map.ofEntries(
            Map.entry("de", "Lithium"),
            Map.entry("en", "Lithium"),
            Map.entry("fr", "Lithium"),
            Map.entry("zh", "锂"),
            Map.entry("ru", "Литий"),
            Map.entry("jp", "リチウム")
        ),
        6.94,
        0.98,
        "[He] 2s^1",
        454,     // 181 °C + 273.15 = 454.15 K (gerundet)
        1620,    // 1347 °C + 273.15 = 1620.15 K (gerundet)
        new byte[] {1},
        -3.04,
        Map.ofEntries(
            Map.entry("de", "Alkalimetall"),
            Map.entry("en", "Alkali metal"),
            Map.entry("fr", "Métal alcalin"),
            Map.entry("zh", "碱金属"),
            Map.entry("ru", "щелочной металл"),
            Map.entry("jp", "アルカリ金属")
        )
    );

    private final static ChemicalElement BERYLLIUM = new ChemicalElement(
        (byte) 4,
        "Be",
        Map.ofEntries(
            Map.entry("de", "Beryllium"),
            Map.entry("en", "Beryllium"),
            Map.entry("fr", "Béryllium"),
            Map.entry("zh", "铍"),
            Map.entry("ru", "Бериллий"),
            Map.entry("jp", "ベリリウム")
        ),
        9.0122,
        1.57,
        "[He] 2s^2",
        1560,    // 1287 °C + 273.15 = 1560.15 K (gerundet)
        2743,    // 2470 °C + 273.15 = 2743.15 K (gerundet)
        new byte[]{2},
        -1.85,
        Map.ofEntries(
            Map.entry("de", "Erdalkalimetall"),
            Map.entry("en", "Alkaline earth metal"),
            Map.entry("fr", "Métal alcalino-terreux"),
            Map.entry("zh", "碱土金属"),
            Map.entry("ru", "щелочноземельный металл"),
            Map.entry("jp", "アルカリ土類金属")
        )
    );

    private final static ChemicalElement BORON = new ChemicalElement(
        (byte) 5,
        "B",
        Map.ofEntries(
            Map.entry("de", "Bor"),
            Map.entry("en", "Boron"),
            Map.entry("fr", "Bore"),
            Map.entry("zh", "硼"),
            Map.entry("ru", "Бор"),
            Map.entry("jp", "ホウ素")
        ),
        10.81,
        2.04,
        "[He] 2s^2 2p^1",
        2349,   // 2076 °C + 273.15 = 2349.15 K (gerundet)
        4200,   // 3927 °C + 273.15 = 4200.15 K (gerundet)
        new byte[]{3},
        -0.87,  // Geschätztes elektrochemisches Potential (selten als Ion)
        Map.ofEntries(
            Map.entry("de", "Metalloid"),
            Map.entry("en", "Metalloid"),
            Map.entry("fr", "Métalloïde"),
            Map.entry("zh", "类金属"),
            Map.entry("ru", "Металлоид"),
            Map.entry("jp", "半金属")
        )
    );

    private final static ChemicalElement CARBON = new ChemicalElement(
        (byte) 6,
        "C",
        Map.ofEntries(
            Map.entry("de", "Kohlenstoff"),
            Map.entry("en", "Carbon"),
            Map.entry("fr", "Carbone"),
            Map.entry("zh", "碳"),
            Map.entry("ru", "Углерод"),
            Map.entry("jp", "炭素")
        ),
        12.011,
        2.55,
        "[He] 2s^2 2p^2",
        3823,   // 3550 °C + 273.15 = 3823.15 K (gerundet)
        5100,   // 4827 °C + 273.15 = 5100.15 K (gerundet)
        new byte[]{4, 2, -4},
        -0.20,  // Geschätztes Elektrodenpotential, stark zustandsabhängig (Graphit, Diamant, etc.)
        Map.ofEntries(
            Map.entry("de", "Nichtmetall"),
            Map.entry("en", "Nonmetal"),
            Map.entry("fr", "Non-métal"),
            Map.entry("zh", "非金属"),
            Map.entry("ru", "неметалл"),
            Map.entry("jp", "非金属")
        )
    );

    private final static ChemicalElement NITROGEN = new ChemicalElement(
        (byte) 7,
        "N",
        Map.ofEntries(
            Map.entry("de", "Stickstoff"),
            Map.entry("en", "Nitrogen"),
            Map.entry("fr", "Azote"),
            Map.entry("zh", "氮"),
            Map.entry("ru", "Азот"),
            Map.entry("jp", "窒素")
        ),
        14.007,
        3.04,
        "[He] 2s^2 2p^3",
        63,     // -210 °C + 273.15 = 63.15 K (gerundet)
        77,     // -196 °C + 273.15 = 77.15 K (gerundet)
        new byte[]{3, 5, -3},
        Double.NaN,   // Standardelektrodenpotential ca. 0 V (reaktionsabhängig)
        Map.ofEntries(
            Map.entry("de", "Nichtmetall"),
            Map.entry("en", "Nonmetal"),
            Map.entry("fr", "Non-métal"),
            Map.entry("zh", "非金属"),
            Map.entry("ru", "неметалл"),
            Map.entry("jp", "非金属")
        )
    );

    private final static ChemicalElement OXYGEN = new ChemicalElement(
        (byte) 8,
        "O",
        Map.ofEntries(
            Map.entry("de", "Sauerstoff"),
            Map.entry("en", "Oxygen"),
            Map.entry("fr", "Oxygène"),
            Map.entry("zh", "氧"),
            Map.entry("ru", "Кислород"),
            Map.entry("jp", "酸素")
        ),
        15.999,
        3.44,
        "[He] 2s^2 2p^4",
        54,     // -219 °C + 273.15 = 54.15 K (gerundet)
        90,     // -183 °C + 273.15 = 90.15 K (gerundet)
        new byte[]{-2},
        1.23,   // Standard-Elektrodenpotential O₂ + 4H⁺ + 4e⁻ → 2H₂O
        Map.ofEntries(
            Map.entry("de", "Nichtmetall"),
            Map.entry("en", "Nonmetal"),
            Map.entry("fr", "Non-métal"),
            Map.entry("zh", "非金属"),
            Map.entry("ru", "неметалл"),
            Map.entry("jp", "非金属")
        )
    );

    private final static ChemicalElement FLUORINE = new ChemicalElement(
        (byte) 9,
        "F",
        Map.ofEntries(
            Map.entry("de", "Fluor"),
            Map.entry("en", "Fluorine"),
            Map.entry("fr", "Fluor"),
            Map.entry("zh", "氟"),
            Map.entry("ru", "Фтор"),
            Map.entry("jp", "フッ素")
        ),
        18.998,
        3.98,
        "[He] 2s^2 2p^5",
        53,     // -220 °C + 273.15 = 53.15 K (gerundet)
        85,     // -188 °C + 273.15 = 85.15 K (gerundet)
        new byte[]{-1},
        2.87,   // Standard-Elektrodenpotential F₂ + 2e⁻ → 2F⁻
        Map.ofEntries(
            Map.entry("de", "Halogen"),
            Map.entry("en", "Halogen"),
            Map.entry("fr", "Halogène"),
            Map.entry("zh", "卤素"),
            Map.entry("ru", "Галоген"),
            Map.entry("jp", "ハロゲン")
        )
    );

    private final static ChemicalElement NEON = new ChemicalElement(
        (byte) 10,
        "Ne",
        Map.ofEntries(
            Map.entry("de", "Neon"),
            Map.entry("en", "Neon"),
            Map.entry("fr", "Néon"),
            Map.entry("zh", "氖"),
            Map.entry("ru", "Неон"),
            Map.entry("jp", "ネオン")
        ),
        20.180,
        Double.NaN,    // keine Elektronegativität definiert
        "[He] 2s^2 2p^6",
        24,     
        27,     
        new byte[]{},   // keine Oxidationszahlen
        Double.NaN,    // kein elektrochemisches Potential
        Map.ofEntries(
            Map.entry("de", "Edelgas"),
            Map.entry("en", "Noble gas"),
            Map.entry("fr", "Gaz noble"),
            Map.entry("zh", "稀有气体"),
            Map.entry("ru", "Благородный газ"),
            Map.entry("jp", "希ガス")
        )
    );


    private final static ChemicalElement SODIUM = new ChemicalElement(
        (byte) 11,
        "Na",
        Map.ofEntries(
            Map.entry("de", "Natrium"),
            Map.entry("en", "Sodium"),
            Map.entry("fr", "Sodium"),
            Map.entry("zh", "钠"),
            Map.entry("ru", "Натрий"),
            Map.entry("jp", "ナトリウム")
        ),
        22.990,
        0.93,
        "[Ne] 3s^1",
        371,    // 98 °C + 273.15 = 371.15 K (gerundet)
        1156,   // 883 °C + 273.15 = 1156.15 K (gerundet)
        new byte[]{1},
        -2.71,  // Standardelektrodenpotential: Na⁺ + e⁻ → Na(s)
        Map.ofEntries(
            Map.entry("de", "Alkalimetall"),
            Map.entry("en", "Alkali metal"),
            Map.entry("fr", "Métal alcalin"),
            Map.entry("zh", "碱金属"),
            Map.entry("ru", "Щелочной металл"),
            Map.entry("jp", "アルカリ金属")
        )
    );

    private final static ChemicalElement MAGNESIUM = new ChemicalElement(
        (byte) 12,
        "Mg",
        Map.ofEntries(
            Map.entry("de", "Magnesium"),
            Map.entry("en", "Magnesium"),
            Map.entry("fr", "Magnésium"),
            Map.entry("zh", "镁"),
            Map.entry("ru", "Магний"),
            Map.entry("jp", "マグネシウム")
        ),
        24.305,
        1.31,
        "[Ne] 3s^2",
        923,    // 650 °C + 273.15 = 923.15 K (gerundet)
        1364,   // 1091 °C + 273.15 = 1364.15 K (gerundet)
        new byte[]{2},
        -2.37,  // Standardelektrodenpotential: Mg²⁺ + 2e⁻ → Mg(s)
        Map.ofEntries(
            Map.entry("de", "Erdalkalimetall"),
            Map.entry("en", "Alkaline earth metal"),
            Map.entry("fr", "Métal alcalino-terreux"),
            Map.entry("zh", "碱土金属"),
            Map.entry("ru", "Щёлочноземельный металл"),
            Map.entry("jp", "アルカリ土類金属")
        )
    );

    private final static ChemicalElement ALUMINUM = new ChemicalElement(
        (byte) 13,
        "Al",
        Map.ofEntries(
            Map.entry("de", "Aluminium"),
            Map.entry("en", "Aluminum"),
            Map.entry("fr", "Aluminium"),
            Map.entry("zh", "铝"),
            Map.entry("ru", "Алюминий"),
            Map.entry("jp", "アルミニウム")
        ),
        26.982,
        1.61,
        "[Ne] 3s^2 3p^1",
        933,    // 660 °C + 273.15 = 933.15 K (gerundet)
        2743,   // 2470 °C + 273.15 = 2743.15 K (gerundet)
        new byte[]{3},
        -1.66,  // Standardelektrodenpotential: Al³⁺ + 3e⁻ → Al(s)
        Map.ofEntries(
            Map.entry("de", "Leichtmetall"),      // Aluminium ist eher Leichtmetall als Übergangsmetall
            Map.entry("en", "Light metal"),
            Map.entry("fr", "Métal léger"),
            Map.entry("zh", "轻金属"),
            Map.entry("ru", "Легкий металл"),
            Map.entry("jp", "軽金属")
        )
    );

    private final static ChemicalElement SILICON = new ChemicalElement(
        (byte) 14,
        "Si",
        Map.ofEntries(
            Map.entry("de", "Silicium"),
            Map.entry("en", "Silicon"),
            Map.entry("fr", "Silicium"),
            Map.entry("zh", "硅"),
            Map.entry("ru", "Кремний"),
            Map.entry("jp", "ケイ素")
        ),
        28.085,
        1.90,
        "[Ne] 3s^2 3p^2",
        1687,  // 1414 °C = 1687 K
        3538,  // 3265 °C = 3538 K
        new byte[]{4, -4},
        Double.NaN,  // Geschätztes elektrochemisches Potential (ungefähr, da Halbleiter)
        Map.ofEntries(
            Map.entry("de", "Halbleiter"),
            Map.entry("en", "Semiconductor"),
            Map.entry("fr", "Semi-conducteur"),
            Map.entry("zh", "半导体"),
            Map.entry("ru", "Полупроводник"),
            Map.entry("jp", "半導体")
        )
    );

    private final static ChemicalElement PHOSPHORUS = new ChemicalElement(
        (byte) 15,
        "P",
        Map.ofEntries(
            Map.entry("de", "Phosphor"),
            Map.entry("en", "Phosphorus"),
            Map.entry("fr", "Phosphore"),
            Map.entry("zh", "磷"),
            Map.entry("ru", "Фосфор"),
            Map.entry("jp", "リン")
        ),
        30.974,
        2.19,
        "[Ne] 3s^2 3p^3",
        317,   // 44 °C = 317 K
        553,   // 280 °C = 553 K
        new byte[]{5, 3, -3},
        Double.NaN,  // Kein klar definierbares elektrochemisches Potential (komplex, kein Standardwert)
        Map.ofEntries(
            Map.entry("de", "Nichtmetall"),
            Map.entry("en", "Nonmetal"),
            Map.entry("fr", "Non-métal"),
            Map.entry("zh", "非金属"),
            Map.entry("ru", "Неметалл"),
            Map.entry("jp", "非金属")
        )
    );

    private final static ChemicalElement SULFUR = new ChemicalElement(
        (byte) 16,
        "S",
        Map.ofEntries(
            Map.entry("de", "Schwefel"),
            Map.entry("en", "Sulfur"),
            Map.entry("fr", "Soufre"),
            Map.entry("zh", "硫"),
            Map.entry("ru", "Сера"),
            Map.entry("jp", "硫黄")
        ),
        32.06,
        2.58,
        "[Ne] 3s^2 3p^4",
        388,   // 115 °C = 388 K
        718,   // 445 °C = 718 K
        new byte[]{-2, 2, 4, 6},
        0.14,  // Geschätztes Elektrodenpotential
        Map.ofEntries(
            Map.entry("de", "Nichtmetall"),
            Map.entry("en", "Nonmetal"),
            Map.entry("fr", "Non-métal"),
            Map.entry("zh", "非金属"),
            Map.entry("ru", "Неметалл"),
            Map.entry("jp", "非金属")
        )
    );

    private final static ChemicalElement CHLORINE = new ChemicalElement(
        (byte) 17,
        "Cl",
        Map.ofEntries(
            Map.entry("de", "Chlor"),
            Map.entry("en", "Chlorine"),
            Map.entry("fr", "Chlore"),
            Map.entry("zh", "氯"),
            Map.entry("ru", "Хлор"),
            Map.entry("jp", "塩素")
        ),
        35.45,
        3.16,
        "[Ne] 3s^2 3p^5",
        172,   // -101 °C = 172 K
        238,   // -35 °C = 238 K
        new byte[]{-1, 1, 3, 5, 7},
        1.36,  // Standard-Elektrodenpotential
        Map.ofEntries(
            Map.entry("de", "Halogen"),
            Map.entry("en", "Halogen"),
            Map.entry("fr", "Halogène"),
            Map.entry("zh", "卤素"),
            Map.entry("ru", "Галоген"),
            Map.entry("jp", "ハロゲン")
        )
    );

    private final static ChemicalElement ARGON = new ChemicalElement(
        (byte) 18,
        "Ar",
        Map.ofEntries(
            Map.entry("de", "Argon"),
            Map.entry("en", "Argon"),
            Map.entry("fr", "Argon"),
            Map.entry("zh", "氩"),
            Map.entry("ru", "Аргон"),
            Map.entry("jp", "アルゴン")
        ),
        39.948,
        Double.NaN,    // Edelgas: keine definierte Elektronegativität, oft als 0 angegeben (geschätzt)
        "[Ne] 3s^2 3p^6",
        84,     // -189 °C = 84 K
        87,     // -186 °C = 87 K
        new byte[]{},  // Keine Oxidationszahlen (Edelgas)
        Double.NaN,    // Elektrodenpotential nicht definiert (geschätzt)
        Map.ofEntries(
            Map.entry("de", "Edelgas"),
            Map.entry("en", "Noble gas"),
            Map.entry("fr", "Gaz noble"),
            Map.entry("zh", "稀有气体"),
            Map.entry("ru", "Благородный газ"),
            Map.entry("jp", "希ガス")
        )
    );

    private final static ChemicalElement POTASSIUM = new ChemicalElement(
        (byte) 19,
        "K",
        Map.ofEntries(
            Map.entry("de", "Kalium"),
            Map.entry("en", "Potassium"),
            Map.entry("fr", "Potassium"),
            Map.entry("zh", "钾"),
            Map.entry("ru", "Калий"),
            Map.entry("jp", "カリウム")
        ),
        39.098,
        0.82,
        "[Ar] 4s^1",
        337,   // 64 °C = 337 K
        1047,  // 774 °C = 1047 K
        new byte[]{1},
        -2.93,  // Standard-Elektrodenpotential (häufig -2.93 V, geschätzt)
        Map.ofEntries(
            Map.entry("de", "Alkalimetall"),
            Map.entry("en", "Alkali metal"),
            Map.entry("fr", "Métal alcalin"),
            Map.entry("zh", "碱金属"),
            Map.entry("ru", "Щелочной металл"),
            Map.entry("jp", "アルカリ金属")
        )
    );

    private final static ChemicalElement CALCIUM = new ChemicalElement(
        (byte) 20,
        "Ca",
        Map.ofEntries(
            Map.entry("de", "Calcium"),
            Map.entry("en", "Calcium"),
            Map.entry("fr", "Calcium"),
            Map.entry("zh", "钙"),
            Map.entry("ru", "Кальций"),
            Map.entry("jp", "カルシウム")
        ),
        40.078,
        1.00,
        "[Ar] 4s^2",
        1115,  // 842 °C = 1115 K
        1757,  // 1484 °C = 1757 K
        new byte[]{2},
        -2.87,  // Standard-Elektrodenpotential (geschätzt)
        Map.ofEntries(
            Map.entry("de", "Erdalkalimetall"),
            Map.entry("en", "Alkaline earth metal"),
            Map.entry("fr", "Métal alcalino-terreux"),
            Map.entry("zh", "碱土金属"),
            Map.entry("ru", "Щёлочноземельный металл"),
            Map.entry("jp", "アルカリ土類金属")
        )
    );

    private final static ChemicalElement SCANDIUM = new ChemicalElement(
        (byte) 21,
        "Sc",
        Map.ofEntries(
            Map.entry("de", "Scandium"),
            Map.entry("en", "Scandium"),
            Map.entry("fr", "Scandium"),
            Map.entry("zh", "钪"),
            Map.entry("ru", "Скандий"),
            Map.entry("jp", "スカンジウム")
        ),
        44.956,
        1.36,
        "[Ar] 3d^1 4s^2",
        1814,  // 1541 °C = 1814 K
        3109,  // 2836 °C = 3109 K
        new byte[]{3},
        -2.10,  // Standard-Elektrodenpotential (geschätzt, schwierig zu finden)
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement TITANIUM = new ChemicalElement(
        (byte) 22,
        "Ti",
        Map.ofEntries(
            Map.entry("de", "Titan"),
            Map.entry("en", "Titanium"),
            Map.entry("fr", "Titane"),
            Map.entry("zh", "钛"),
            Map.entry("ru", "Титан"),
            Map.entry("jp", "チタン")
        ),
        47.867,
        1.54,
        "[Ar] 3d^2 4s^2",
        1941,  // 1668 °C = 1941 K
        3560,  // 3287 °C = 3560 K
        new byte[]{4, 3, 2},
        -1.63,  // Standard-Elektrodenpotential (geschätzt)
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement VANADIUM = new ChemicalElement(
        (byte) 23,
        "V",
        Map.ofEntries(
            Map.entry("de", "Vanadium"),
            Map.entry("en", "Vanadium"),
            Map.entry("fr", "Vanadium"),
            Map.entry("zh", "钒"),
            Map.entry("ru", "Ванадий"),
            Map.entry("jp", "バナジウム")
        ),
        50.942,
        1.63,
        "[Ar] 3d^3 4s^2",
        2183,  // 1910 °C = 2183 K
        3680,  // 3407 °C = 3680 K
        new byte[]{5, 4, 3, 2},
        -1.18,  // Standard-Elektrodenpotential (geschätzt)
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement CHROMIUM = new ChemicalElement(
        (byte) 24,
        "Cr",
        Map.ofEntries(
            Map.entry("de", "Chrom"),
            Map.entry("en", "Chromium"),
            Map.entry("fr", "Chrome"),
            Map.entry("zh", "铬"),
            Map.entry("ru", "Хром"),
            Map.entry("jp", "クロム")
        ),
        51.996,
        1.66,
        "[Ar] 3d^5 4s^1",
        2180,  // 1907 °C = 2180 K
        2944,  // 2671 °C = 2944 K
        new byte[]{6, 3, 2, 0},
        -0.74,  // Elektrodenpotential (Wert angegeben, keine Schätzung)
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement MANGANESE = new ChemicalElement(
        (byte) 25,
        "Mn",
        Map.ofEntries(
            Map.entry("de", "Mangan"),
            Map.entry("en", "Manganese"),
            Map.entry("fr", "Manganèse"),
            Map.entry("zh", "锰"),
            Map.entry("ru", "Марганец"),
            Map.entry("jp", "マンガン")
        ),
        54.938,
        1.55,
        "[Ar] 3d^5 4s^2",
        1519,  // 1246 °C = 1519 K
        2334,  // 2061 °C = 2334 K
        new byte[]{7, 6, 4, 3, 2},
        1.51,  // Elektrodenpotential (Wert angegeben)
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement IRON = new ChemicalElement(
        (byte) 26,
        "Fe",
        Map.ofEntries(
            Map.entry("de", "Eisen"),
            Map.entry("en", "Iron"),
            Map.entry("fr", "Fer"),
            Map.entry("zh", "铁"),
            Map.entry("ru", "Железо"),
            Map.entry("jp", "鉄")
        ),
        55.845,
        1.83,
        "[Ar] 3d^6 4s^2",
        1811,  // 1538 °C = 1811 K
        3134,  // 2862 °C = 3134 K
        new byte[]{3, 2},
        -0.44,  // Elektrodenpotential (Wert angegeben)
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement COBALT = new ChemicalElement(
        (byte) 27,
        "Co",
        Map.ofEntries(
            Map.entry("de", "Cobalt"),
            Map.entry("en", "Cobalt"),
            Map.entry("fr", "Cobalt"),
            Map.entry("zh", "钴"),
            Map.entry("ru", "Кобальт"),
            Map.entry("jp", "コバルト")
        ),
        58.933,
        1.88,
        "[Ar] 3d^7 4s^2",
        1768,   // 1495 °C = 1768 K
        3200,   // 2927 °C = 3200 K (gerundeter Wert)
        new byte[]{3, 2},
        -0.28,   // Elektrodenpotential (in V, Standard)
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement NICKEL = new ChemicalElement(
        (byte) 28,
        "Ni",
        Map.ofEntries(
            Map.entry("de", "Nickel"),
            Map.entry("en", "Nickel"),
            Map.entry("fr", "Nickel"),
            Map.entry("zh", "镍"),
            Map.entry("ru", "Никель"),
            Map.entry("jp", "ニッケル")
        ),
        58.693,
        1.91,
        "[Ar] 3d^8 4s^2",
        1728,   // 1455 °C = 1728 K
        3003,   // 2730 °C = 3003 K
        new byte[]{2, 3},
        -0.25,   // Elektrodenpotential (in V, Standard)
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement COPPER = new ChemicalElement(
        (byte) 29,
        "Cu",
        Map.ofEntries(
            Map.entry("de", "Kupfer"),
            Map.entry("en", "Copper"),
            Map.entry("fr", "Cuivre"),
            Map.entry("zh", "铜"),
            Map.entry("ru", "Медь"),
            Map.entry("jp", "銅")
        ),
        63.546,
        1.90,
        "[Ar] 3d^10 4s^1",
        1358,   // 1085 °C = 1358 K
        2835,   // 2562 °C = 2835 K
        new byte[]{2, 1},
        0.34,   // Standard-Elektrodenpotential Cu^2+/Cu in V (statt 1.90, 1.90 war wohl Elektronegativität)
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement ZINC = new ChemicalElement(
        (byte) 30,
        "Zn",
        Map.ofEntries(
            Map.entry("de", "Zink"),
            Map.entry("en", "Zinc"),
            Map.entry("fr", "Zinc"),
            Map.entry("zh", "锌"),
            Map.entry("ru", "Цинк"),
            Map.entry("jp", "亜鉛")
        ),
        65.38,
        1.65,
        "[Ar] 3d^10 4s^2",
        692,    // 419 °C = 692 K
        1180,   // 907 °C = 1180 K
        new byte[]{2},
        -0.76,  // Standard-Elektrodenpotential Zn^2+/Zn (geschätzt)
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement GALLIUM = new ChemicalElement(
        (byte) 31,
        "Ga",
        Map.ofEntries(
            Map.entry("de", "Gallium"),
            Map.entry("en", "Gallium"),
            Map.entry("fr", "Gallium"),
            Map.entry("zh", "镓"),
            Map.entry("ru", "Галлий"),
            Map.entry("jp", "ガリウム")
        ),
        69.723,
        1.81,
        "[Ar] 3d^10 4s^2 4p^1",
        303,    // 30 °C = 303 K (geschätzt, da ca. 29,76 °C)
        2673,   // 2400 °C = 2673 K (gerundet)
        new byte[]{3},
        0.53,   // Geschätztes Standard-Elektrodenpotential (kein exakter Wert)
        Map.ofEntries(
            Map.entry("de", "Metall"),
            Map.entry("en", "Metal"),
            Map.entry("fr", "Métal"),
            Map.entry("zh", "金属"),
            Map.entry("ru", "Металл"),
            Map.entry("jp", "金属")
        )
    );

    private final static ChemicalElement GERMANIUM = new ChemicalElement(
        (byte) 32,
        "Ge",
        Map.ofEntries(
            Map.entry("de", "Germanium"),
            Map.entry("en", "Germanium"),
            Map.entry("fr", "Germanium"),
            Map.entry("zh", "锗"),
            Map.entry("ru", "Германий"),
            Map.entry("jp", "ゲルマニウム")
        ),
        72.630,
        2.01,
        "[Ar] 3d^10 4s^2 4p^2",
        1211,   // 938 °C = 1211 K
        3106,   // 2833 °C = 3106 K
        new byte[]{4, 2},
        2.01,   // Geschätztes Standard-Elektrodenpotential
        Map.ofEntries(
            Map.entry("de", "Halbmetall"),
            Map.entry("en", "Metalloid"),
            Map.entry("fr", "Métalloïde"),
            Map.entry("zh", "类金属"),
            Map.entry("ru", "Металлоид"),
            Map.entry("jp", "半金属")
        )
    );

    private final static ChemicalElement ARSENIC = new ChemicalElement(
        (byte) 33,
        "As",
        Map.ofEntries(
            Map.entry("de", "Arsen"),
            Map.entry("en", "Arsenic"),
            Map.entry("fr", "Arsenic"),
            Map.entry("zh", "砷"),
            Map.entry("ru", "Мышьяк"),
            Map.entry("jp", "ヒ素")
        ),
        74.922,
        2.18,
        "[Ar] 3d^10 4s^2 4p^3",
        1090,   // 817 °C = 1090 K (Schmelzpunkt)
        887,    // 614 °C = 887 K (Siedepunkt, arsen sublimiert oft, Wert geschätzt)
        new byte[]{-3, 3, 5},
        2.18,   // Geschätztes Standard-Elektrodenpotential
        Map.ofEntries(
            Map.entry("de", "Halbmetall"),
            Map.entry("en", "Metalloid"),
            Map.entry("fr", "Métalloïde"),
            Map.entry("zh", "类金属"),
            Map.entry("ru", "Металлоид"),
            Map.entry("jp", "半金属")
        )
    );

    private final static ChemicalElement SELENIUM = new ChemicalElement(
        (byte) 34,
        "Se",
        Map.ofEntries(
            Map.entry("de", "Selen"),
            Map.entry("en", "Selenium"),
            Map.entry("fr", "Sélénium"),
            Map.entry("zh", "硒"),
            Map.entry("ru", "Селен"),
            Map.entry("jp", "セレン")
        ),
        78.971,
        2.55,
        "[Ar] 3d^10 4s^2 4p^4",
        494,    // 221 °C = 494 K
        958,    // 685 °C = 958 K
        new byte[]{-2, 2, 4, 6},
        0.74,   // Geschätztes Standard-Elektrodenpotential
        Map.ofEntries(
            Map.entry("de", "Nichtmetall"),
            Map.entry("en", "Nonmetal"),
            Map.entry("fr", "Non-métal"),
            Map.entry("zh", "非金属"),
            Map.entry("ru", "Неметалл"),
            Map.entry("jp", "非金属")
        )
    );

    private final static ChemicalElement BROMINE = new ChemicalElement(
        (byte) 35,
        "Br",
        Map.ofEntries(
            Map.entry("de", "Brom"),
            Map.entry("en", "Bromine"),
            Map.entry("fr", "Brome"),
            Map.entry("zh", "溴"),
            Map.entry("ru", "Бром"),
            Map.entry("jp", "臭素")
        ),
        79.904,
        2.96,
        "[Ar] 3d^10 4s^2 4p^5",
        266,    // -7 °C = 266 K (Schmelzpunkt)
        332,    // 59 °C = 332 K (Siedepunkt)
        new byte[]{-1, 1, 3, 5, 7},
        1.065,  // Standard-Elektrodenpotential (geschätzt)
        Map.ofEntries(
            Map.entry("de", "Halogen"),
            Map.entry("en", "Halogen"),
            Map.entry("fr", "Halogène"),
            Map.entry("zh", "卤素"),
            Map.entry("ru", "Галоген"),
            Map.entry("jp", "ハロゲン")
        )
    );

    private final static ChemicalElement KRYPTON = new ChemicalElement(
        (byte) 36,
        "Kr",
        Map.ofEntries(
            Map.entry("de", "Krypton"),
            Map.entry("en", "Krypton"),
            Map.entry("fr", "Krypton"),
            Map.entry("zh", "氪"),
            Map.entry("ru", "Криптон"),
            Map.entry("jp", "クリプトン")
        ),
        83.798,
        Double.NaN,         // Elektronegativität (Pauling)
        "[Ar] 3d^10 4s^2 4p^6",
        116,        // -157 °C = 116 K (Schmelzpunkt)
        120,        // -153 °C = 120 K (Siedepunkt)
        new byte[]{0, 2, 4, 6},
        Double.NaN,        // Elektrodenpotential (sehr negativ, Edelgas)
        Map.ofEntries(
            Map.entry("de", "Edelgas"),
            Map.entry("en", "Noble gas"),
            Map.entry("fr", "Gaz noble"),
            Map.entry("zh", "稀有气体"),
            Map.entry("ru", "Благородный газ"),
            Map.entry("jp", "希ガス")
        )
    );

    private final static ChemicalElement RUBIDIUM = new ChemicalElement(
        (byte) 37,
        "Rb",
        Map.ofEntries(
            Map.entry("de", "Rubidium"),
            Map.entry("en", "Rubidium"),
            Map.entry("fr", "Rubidium"),
            Map.entry("zh", "铷"),
            Map.entry("ru", "Рубидий"),
            Map.entry("jp", "ルビジウム")
        ),
        85.468,
        0.82,
        "[Kr] 5s^1",
        312,                // Schmelzpunkt in Kelvin (39 °C + 273)
        961,                // Siedepunkt in Kelvin (688 °C + 273)
        new byte[]{1},
        -2.98,              // Standard-Elektrodenpotential (V)
        Map.ofEntries(
            Map.entry("de", "Alkalimetall"),
            Map.entry("en", "Alkali metal"),
            Map.entry("fr", "Métal alcalin"),
            Map.entry("zh", "碱金属"),
            Map.entry("ru", "Щелочной металл"),
            Map.entry("jp", "アルカリ金属")
        )
    );

    private final static ChemicalElement STRONTIUM = new ChemicalElement(
        (byte) 38,
        "Sr",
        Map.ofEntries(
            Map.entry("de", "Strontium"),
            Map.entry("en", "Strontium"),
            Map.entry("fr", "Strontium"),
            Map.entry("zh", "锶"),
            Map.entry("ru", "Стронций"),
            Map.entry("jp", "ストロンチウム")
        ),
        87.62,
        0.95,
        "[Kr] 5s^2",
        1050,               // Schmelzpunkt in Kelvin (777 °C + 273)
        1655,               // Siedepunkt in Kelvin (1382 °C + 273)
        new byte[]{2},
        -2.89,              // Standard-Elektrodenpotential (V)
        Map.ofEntries(
            Map.entry("de", "Erdalkalimetall"),
            Map.entry("en", "Alkaline earth metal"),
            Map.entry("fr", "Métal alcalino-terreux"),
            Map.entry("zh", "碱土金属"),
            Map.entry("ru", "Щелочноземельный металл"),
            Map.entry("jp", "アルカリ土類金属")
        )
    );

    private final static ChemicalElement YTTRIUM = new ChemicalElement(
        (byte) 39,
        "Y",
        Map.ofEntries(
            Map.entry("de", "Yttrium"),
            Map.entry("en", "Yttrium"),
            Map.entry("fr", "Yttrium"),
            Map.entry("zh", "钇"),
            Map.entry("ru", "Иттрий"),
            Map.entry("jp", "イットリウム")
        ),
        88.906,
        1.22,
        "[Kr] 4d^1 5s^2",
        1799,               // Schmelzpunkt in Kelvin (1526 °C + 273)
        3618,               // Siedepunkt in Kelvin (3345 °C + 273)
        new byte[]{3},
        -2.37,              // Standard-Elektrodenpotential (V)
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement ZIRCONIUM = new ChemicalElement(
        (byte) 40,
        "Zr",
        Map.ofEntries(
            Map.entry("de", "Zirkonium"),
            Map.entry("en", "Zirconium"),
            Map.entry("fr", "Zirconium"),
            Map.entry("zh", "锆"),
            Map.entry("ru", "Цирконий"),
            Map.entry("jp", "ジルコニウム")
        ),
        91.224,
        1.33,
        "[Kr] 4d^2 5s^2",
        2128,                   // Schmelzpunkt in Kelvin (1855 °C + 273)
        4682,                   // Siedepunkt in Kelvin (4409 °C + 273)
        new byte[]{4},
        -1.45,                  // Standard-Elektrodenpotential (V) (geschätzt)
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement NIOBIUM = new ChemicalElement(
        (byte) 41,
        "Nb",
        Map.ofEntries(
            Map.entry("de", "Niob"),
            Map.entry("en", "Niobium"),
            Map.entry("fr", "Niobium"),
            Map.entry("zh", "铌"),
            Map.entry("ru", "Ниобий"),
            Map.entry("jp", "ニオブ")
        ),
        92.906,
        1.6,
        "[Kr] 4d^4 5s^1",
        2750,                   // Schmelzpunkt in Kelvin (2477 °C + 273)
        5017,                   // Siedepunkt in Kelvin (4744 °C + 273)
        new byte[]{5, 4, 3},
        -1.1,                   // Standard-Elektrodenpotential (V) (geschätzt)
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement MOLYBDENUM = new ChemicalElement(
        (byte) 42,
        "Mo",
        Map.ofEntries(
            Map.entry("de", "Molybdän"),
            Map.entry("en", "Molybdenum"),
            Map.entry("fr", "Molybdène"),
            Map.entry("zh", "钼"),
            Map.entry("ru", "Молибден"),
            Map.entry("jp", "モリブデン")
        ),
        95.95,
        2.16,
        "[Kr] 4d^5 5s^1",
        2896,                   // Schmelzpunkt in Kelvin (2623 °C + 273)
        4912,                   // Siedepunkt in Kelvin (4639 °C + 273)
        new byte[]{6, 4, 2},
        0.15,                   // Standard-Elektrodenpotential (V)
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement TECHNETIUM = new ChemicalElement(
        (byte) 43,
        "Tc",
        Map.ofEntries(
            Map.entry("de", "Technetium"),
            Map.entry("en", "Technetium"),
            Map.entry("fr", "Technétium"),
            Map.entry("zh", "锝"),
            Map.entry("ru", "Технеций"),
            Map.entry("jp", "テクネチウム")
        ),
        98.0,
        1.9,
        "[Kr] 4d^5 5s^2",
        2157,
        4265,
        new byte[]{7, 4},
        1.9,  // geschätzt
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement RUTHENIUM = new ChemicalElement(
        (byte) 44,
        "Ru",
        Map.ofEntries(
            Map.entry("de", "Ruthenium"),
            Map.entry("en", "Ruthenium"),
            Map.entry("fr", "Ruthénium"),
            Map.entry("zh", "钌"),
            Map.entry("ru", "Рутений"),
            Map.entry("jp", "ルテニウム")
        ),
        101.07,
        2.2,
        "[Kr] 4d^7 5s^1",
        2334,
        4150,
        new byte[]{8, 6, 4, 3, 2},
        2.2,  // geschätzt
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement RHODIUM = new ChemicalElement(
        (byte) 45,
        "Rh",
        Map.ofEntries(
            Map.entry("de", "Rhodium"),
            Map.entry("en", "Rhodium"),
            Map.entry("fr", "Rhodium"),
            Map.entry("zh", "铑"),
            Map.entry("ru", "Родий"),
            Map.entry("jp", "ロジウム")
        ),
        102.91,
        2.28,
        "[Kr] 4d^8 5s^1",
        1964,
        3695,
        new byte[]{3},
        Double.NaN, 
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement PALLADIUM = new ChemicalElement(
        (byte) 46,
        "Pd",
        Map.ofEntries(
            Map.entry("de", "Palladium"),
            Map.entry("en", "Palladium"),
            Map.entry("fr", "Palladium"),
            Map.entry("zh", "钯"),
            Map.entry("ru", "Палладий"),
            Map.entry("jp", "パラジウム")
        ),
        106.42,
        2.20,
        "[Kr] 4d^10",
        1554,
        2963,
        new byte[]{2, 4},
        Double.NaN,  
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement SILVER = new ChemicalElement(
        (byte) 47,
        "Ag",
        Map.ofEntries(
            Map.entry("de", "Silber"),
            Map.entry("en", "Silver"),
            Map.entry("fr", "Argent"),
            Map.entry("zh", "银"),
            Map.entry("ru", "Серебро"),
            Map.entry("jp", "銀")
        ),
        107.87,
        1.93,
        "[Kr] 4d^10 5s^1",
        962,
        2162,
        new byte[]{1},
        0.80,  // korrigiert: Standard-Elektrodenpotential für Silber ist ca. +0.80 V (nicht 1.93)
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement CADMIUM = new ChemicalElement(
        (byte) 48,
        "Cd",
        Map.ofEntries(
            Map.entry("de", "Cadmium"),
            Map.entry("en", "Cadmium"),
            Map.entry("fr", "Cadmium"),
            Map.entry("zh", "镉"),
            Map.entry("ru", "Кадмий"),
            Map.entry("jp", "カドミウム")
        ),
        112.41,
        1.69,
        "[Kr] 4d^10 5s^2",
        594,    // Schmelzpunkt in Kelvin (321 °C + 273)
        1040,   // Siedepunkt in Kelvin (767 °C + 273)
        new byte[]{2},
        -0.40,  // Standard-Elektrodenpotential (V)
        Map.ofEntries(
            Map.entry("de", "Post-Übergangsmetall"),
            Map.entry("en", "Post-transition metal"),
            Map.entry("fr", "Métal post-transition"),
            Map.entry("zh", "后过渡金属"),
            Map.entry("ru", "Постпереходный металл"),
            Map.entry("jp", "後期遷移金属")
        )
    );

    private final static ChemicalElement INDIUM = new ChemicalElement(
        (byte) 49,
        "In",
        Map.ofEntries(
            Map.entry("de", "Indium"),
            Map.entry("en", "Indium"),
            Map.entry("fr", "Indium"),
            Map.entry("zh", "铟"),
            Map.entry("ru", "Индий"),
            Map.entry("jp", "インジウム")
        ),
        114.82,
        1.78,
        "[Kr] 4d^10 5s^2 5p^1",
        429,    // korrigiert: Schmelzpunkt 429 K (nicht 157)
        2345,   // korrigiert: Siedepunkt 2345 K (nicht 2072)
        new byte[]{3},
        0.34,  // geschätzt Standard-Elektrodenpotential ca. +0.34 V
        Map.ofEntries(
            Map.entry("de", "Post-Übergangsmetall"),
            Map.entry("en", "Post-transition metal"),
            Map.entry("fr", "Métal post-transition"),
            Map.entry("zh", "后过渡金属"),
            Map.entry("ru", "Постпереходный металл"),
            Map.entry("jp", "後遷移金属")
        )
    );

    private final static ChemicalElement TIN = new ChemicalElement(
        (byte) 50,
        "Sn",
        Map.ofEntries(
            Map.entry("de", "Zinn"),
            Map.entry("en", "Tin"),
            Map.entry("fr", "Étain"),
            Map.entry("zh", "锡"),
            Map.entry("ru", "Олово"),
            Map.entry("jp", "スズ")
        ),
        118.71,
        1.96,
        "[Kr] 4d^10 5s^2 5p^2",
        505,    // korrigiert: Schmelzpunkt 505 K (nicht 232)
        2875,   // korrigiert: Siedepunkt 2875 K (nicht 2602)
        new byte[]{4, 2},
        -0.14,  // Standard-Elektrodenpotential ca. -0.14 V (geschätzt)
        Map.ofEntries(
            Map.entry("de", "Post-Übergangsmetall"),
            Map.entry("en", "Post-transition metal"),
            Map.entry("fr", "Métal post-transition"),
            Map.entry("zh", "后过渡金属"),
            Map.entry("ru", "Постпереходный металл"),
            Map.entry("jp", "後遷移金属")
        )
    );

    private final static ChemicalElement ANTIMONY = new ChemicalElement(
        (byte) 51,
        "Sb",
        Map.ofEntries(
            Map.entry("de", "Antimon"),
            Map.entry("en", "Antimony"),
            Map.entry("fr", "Antimoine"),
            Map.entry("zh", "锑"),
            Map.entry("ru", "Сурьма"),
            Map.entry("jp", "アンチモン")
        ),
        121.76,
        2.05,
        "[Kr] 4d^10 5s^2 5p^3",
        903,   // 630 °C → 903 K
        1860,  // 1587 °C → 1860 K
        new byte[]{-3, 3, 5},
        Double.NaN,  // geschätzt
        Map.ofEntries(
            Map.entry("de", "Halbmetall"),
            Map.entry("en", "Metalloid"),
            Map.entry("fr", "Métalloïde"),
            Map.entry("zh", "类金属"),
            Map.entry("ru", "Металлоид"),
            Map.entry("jp", "半金属")
        )
    );

    private final static ChemicalElement TELLURIUM = new ChemicalElement(
        (byte) 52,
        "Te",
        Map.ofEntries(
            Map.entry("de", "Tellur"),
            Map.entry("en", "Tellurium"),
            Map.entry("fr", "Tellure"),
            Map.entry("zh", "碲"),
            Map.entry("ru", "Теллур"),
            Map.entry("jp", "テルル")
        ),
        127.60,
        2.1,
        "[Kr] 4d^10 5s^2 5p^4",
        722,   // 449 °C → 722 K
        1261,  // 988 °C → 1261 K
        new byte[]{-2, 2, 4, 6},
        Double.NaN,  // Kein wissenschaftlich belegtes Standard-Elektrodenpotential vorhanden
        Map.ofEntries(
            Map.entry("de", "Halbmetall"),
            Map.entry("en", "Metalloid"),
            Map.entry("fr", "Métalloïde"),
            Map.entry("zh", "类金属"),
            Map.entry("ru", "Металлоид"),
            Map.entry("jp", "半金属")
        )
    );

    private final static ChemicalElement IODINE = new ChemicalElement(
        (byte) 53,
        "I",
        Map.ofEntries(
            Map.entry("de", "Iod"),
            Map.entry("en", "Iodine"),
            Map.entry("fr", "Iode"),
            Map.entry("zh", "碘"),
            Map.entry("ru", "Йод"),
            Map.entry("jp", "ヨウ素")
        ),
        126.90,
        2.66,
        "[Kr] 4d^10 5s^2 5p^5",
        387,   // 114 °C → 387 K
        457,   // 184 °C → 457 K
        new byte[]{-1, 1, 3, 5, 7},
        0.54,
        Map.ofEntries(
            Map.entry("de", "Halogen"),
            Map.entry("en", "Halogen"),
            Map.entry("fr", "Halogène"),
            Map.entry("zh", "卤素"),
            Map.entry("ru", "Галоген"),
            Map.entry("jp", "ハロゲン")
        )
    );

    private final static ChemicalElement XENON = new ChemicalElement(
        (byte) 54,
        "Xe",
        Map.ofEntries(
            Map.entry("de", "Xenon"),
            Map.entry("en", "Xenon"),
            Map.entry("fr", "Xénon"),
            Map.entry("zh", "氙"),
            Map.entry("ru", "Ксенон"),
            Map.entry("jp", "希ガス")
        ),
        131.29,
        Double.NaN,  // Keine Elektronegativität für Edelgase
        "[Kr] 4d^10 5s^2 5p^6",
        161,   // -112 °C → 161 K
        165,   // -108 °C → 165 K
        new byte[]{0, 2, 4, 6, 8},
        Double.NaN,  // kein definiertes Standard-Elektrodenpotential, daher 0.0 ohne "geschätzt"
        Map.ofEntries(
            Map.entry("de", "Edelgas"),
            Map.entry("en", "Noble gas"),
            Map.entry("fr", "Gaz noble"),
            Map.entry("zh", "惰性气体"),
            Map.entry("ru", "Инертный газ"),
            Map.entry("jp", "希ガス")
        )
    );

    private final static ChemicalElement CESIUM = new ChemicalElement(
        (byte) 55,
        "Cs",
        Map.ofEntries(
            Map.entry("de", "Cäsium"),
            Map.entry("en", "Cesium"),
            Map.entry("fr", "Césium"),
            Map.entry("zh", "铯"),
            Map.entry("ru", "Цезий"),
            Map.entry("jp", "セシウム")
        ),
        132.91,
        0.79,
        "[Xe] 6s^1",
        301,   // 28 °C → 301 K
        944,   // 671 °C → 944 K
        new byte[]{1},
        -2.92,
        Map.ofEntries(
            Map.entry("de", "Alkalimetall"),
            Map.entry("en", "Alkali metal"),
            Map.entry("fr", "Métal alcalin"),
            Map.entry("zh", "碱金属"),
            Map.entry("ru", "Щелочной металл"),
            Map.entry("jp", "アルカリ金属")
        )
    );

    private final static ChemicalElement BARIUM = new ChemicalElement(
        (byte) 56,
        "Ba",
        Map.ofEntries(
            Map.entry("de", "Barium"),
            Map.entry("en", "Barium"),
            Map.entry("fr", "Baryum"),
            Map.entry("zh", "钡"),
            Map.entry("ru", "Барий"),
            Map.entry("jp", "バリウム")
        ),
        137.33,
        0.89,
        "[Xe] 6s^2",
        1000,  // 727 °C → 1000 K
        2143,  // 1870 °C → 2143 K
        new byte[]{2},
        -2.91,
        Map.ofEntries(
            Map.entry("de", "Erdalkalimetall"),
            Map.entry("en", "Alkaline earth metal"),
            Map.entry("fr", "Métal alcalino-terreux"),
            Map.entry("zh", "碱土金属"),
            Map.entry("ru", "Щёлочноземельный металл"),
            Map.entry("jp", "アルカリ土類金属")
        )
    );

    private final static ChemicalElement LANTHANUM = new ChemicalElement(
        (byte) 57,
        "La",
        Map.ofEntries(
            Map.entry("de", "Lanthan"),
            Map.entry("en", "Lanthanum"),
            Map.entry("fr", "Lanthane"),
            Map.entry("zh", "镧"),
            Map.entry("ru", "Лантан"),
            Map.entry("jp", "ランタン")
        ),
        138.91,
        1.10,
        "[Xe] 5d^1 6s^2",
        1193,  // 920 °C → 1193 K
        3737,  // 3464 °C → 3737 K
        new byte[]{3},
        -2.52,
        Map.ofEntries(
            Map.entry("de", "Lanthanoid"),
            Map.entry("en", "Lanthanide"),
            Map.entry("fr", "Lanthanoïde"),
            Map.entry("zh", "镧系元素"),
            Map.entry("ru", "Лантаноид"),
            Map.entry("jp", "ランタノイド")
        )
    );

    private final static ChemicalElement CERIUM = new ChemicalElement(
        (byte) 58,
        "Ce",
        Map.ofEntries(
            Map.entry("de", "Cer"),
            Map.entry("en", "Cerium"),
            Map.entry("fr", "Cérium"),
            Map.entry("zh", "铈"),
            Map.entry("ru", "Церий"),
            Map.entry("jp", "セリウム")
        ),
        140.12,
        1.12,
        "[Xe] 4f^1 5d^1 6s^2",
        1068,
        3716,
        new byte[]{3, 4},
        -2.34,
        Map.ofEntries(
            Map.entry("de", "Lanthanoid"),
            Map.entry("en", "Lanthanide"),
            Map.entry("fr", "Lanthanoïde"),
            Map.entry("zh", "镧系元素"),
            Map.entry("ru", "Лантаноид"),
            Map.entry("jp", "ランタノイド")
        )
    );


    private final static ChemicalElement PRASEODYMIUM = new ChemicalElement(
        (byte) 59,
        "Pr",
        Map.ofEntries(
            Map.entry("en", "Praseodymium"),
            Map.entry("de", "Praseodym"),
            Map.entry("fr", "Praséodyme"),
            Map.entry("zh", "镨"),
            Map.entry("ru", "Празеодим"),
            Map.entry("jp", "プラセオジム")
        ),
        140.91,
        1.13,
        "[Xe] 4f^3 6s^2",
        1204,  // 931 °C → 1204 K
        3793,  // 3520 °C → 3793 K
        new byte[]{3},
        -2.35,
        Map.ofEntries(
            Map.entry("en", "Lanthanide"),
            Map.entry("de", "Lanthanoid"),
            Map.entry("fr", "Lanthanoïde"),
            Map.entry("zh", "镧系元素"),
            Map.entry("ru", "Лантаноид"),
            Map.entry("jp", "ランタノイド")
        )
    );

    private final static ChemicalElement NEODYMIUM = new ChemicalElement(
        (byte) 60,
        "Nd",
        Map.ofEntries(
            Map.entry("en", "Neodymium"),
            Map.entry("de", "Neodym"),
            Map.entry("fr", "Néodyme"),
            Map.entry("zh", "钕"),
            Map.entry("ru", "Неодим"),
            Map.entry("jp", "ネオジム")
        ),
        144.24,
        1.14,
        "[Xe] 4f^4 6s^2",
        1294,  // 1021 °C → 1294 K
        3373,  // 3100 °C → 3373 K
        new byte[]{3},
        -2.32,
        Map.ofEntries(
            Map.entry("en", "Lanthanide"),
            Map.entry("de", "Lanthanoid"),
            Map.entry("fr", "Lanthanoïde"),
            Map.entry("zh", "镧系元素"),
            Map.entry("ru", "Лантаноид"),
            Map.entry("jp", "ランタノイド")
        )
    );

    private final static ChemicalElement PROMETHIUM = new ChemicalElement(
        (byte) 61,
        "Pm",
        Map.ofEntries(
            Map.entry("de", "Promethium"),
            Map.entry("en", "Promethium"),
            Map.entry("fr", "Prométhium"),
            Map.entry("zh", "钷"),
            Map.entry("ru", "Прометий"),
            Map.entry("jp", "ランタノイド")
        ),
        145.00,
        1.13,
        "[Xe] 4f^5 6s^2",
        1315,  // 1042 °C → 1315 K
        3273,  // 3000 °C → 3273 K
        new byte[]{3},
        Double.NaN,  // Kein wissenschaftlich anerkannter Wert für Elektrodenpotential
        Map.ofEntries(
            Map.entry("de", "Lanthanoid"),
            Map.entry("en", "Lanthanide"),
            Map.entry("fr", "Lanthanoïde"),
            Map.entry("zh", "镧系元素"),
            Map.entry("ru", "Лантаноид"),
            Map.entry("jp", "ランタノイド")
        )
    );

    private final static ChemicalElement SAMARIUM = new ChemicalElement(
        (byte) 62,
        "Sm",
        Map.ofEntries(
            Map.entry("de", "Samarium"),
            Map.entry("en", "Samarium"),
            Map.entry("fr", "Samarium"),
            Map.entry("zh", "钐"),
            Map.entry("ru", "Самарий"),
            Map.entry("jp", "サマリウム")
        ),
        150.36,
        1.17, // Pauling-Elektronegativität
        "[Xe] 4f^6 6s^2",
        1345,   // Schmelzpunkt in Kelvin
        2067,   // Siedepunkt in Kelvin
        new byte[]{2, 3}, // übliche Oxidationszahlen
        Double.NaN,      // Standard-Elektrodenpotential (hier meist nicht bekannt)
        Map.ofEntries(
            Map.entry("de", "Lanthanoid"),
            Map.entry("en", "Lanthanide"),
            Map.entry("fr", "Lanthanoïde"),
            Map.entry("zh", "镧系元素"),
            Map.entry("ru", "Лантаноид"),
            Map.entry("jp", "ランタノイド")
        )
    );

    private final static ChemicalElement EUROPIUM = new ChemicalElement(
        (byte) 63,
        "Eu",
        Map.ofEntries(
            Map.entry("de", "Europium"),
            Map.entry("en", "Europium"),
            Map.entry("fr", "Europium"),
            Map.entry("zh", "铕"),
            Map.entry("ru", "Европий"),
            Map.entry("jp", "ランタノイド")
        ),
        151.96,
        1.20,
        "[Xe] 4f^7 6s^2",
        1095,  // 822 °C → 1095 K
        1802,  // 1529 °C → 1802 K
        new byte[]{2, 3},
        -2.38,
        Map.ofEntries(
            Map.entry("de", "Lanthanoid"),
            Map.entry("en", "Lanthanide"),
            Map.entry("fr", "Lanthanoïde"),
            Map.entry("zh", "镧系元素"),
            Map.entry("ru", "Лантаноид"),
            Map.entry("jp", "ランタノイド")
        )
    );

    private final static ChemicalElement GADOLINIUM = new ChemicalElement(
        (byte) 64,
        "Gd",
        Map.ofEntries(
            Map.entry("de", "Gadolinium"),
            Map.entry("en", "Gadolinium"),
            Map.entry("fr", "Gadolinium"),
            Map.entry("zh", "钆"),
            Map.entry("ru", "Гадолиний"),
            Map.entry("jp", "ガドリニウム")
        ),
        157.25,
        1.20,
        "[Xe] 4f^7 5d^1 6s^2",
        1585,  // 1312 °C → 1585 K
        3523,  // 3250 °C → 3523 K
        new byte[]{3},
        -2.28,
        Map.ofEntries(
            Map.entry("de", "Lanthanoid"),
            Map.entry("en", "Lanthanide"),
            Map.entry("fr", "Lanthanoïde"),
            Map.entry("zh", "镧系元素"),
            Map.entry("ru", "Лантаноид"),
            Map.entry("jp", "ランタノイド")
        )
    );

    private final static ChemicalElement TERBIUM = new ChemicalElement(
        (byte) 65,
        "Tb",
        Map.ofEntries(
            Map.entry("de", "Terbium"),
            Map.entry("en", "Terbium"),
            Map.entry("fr", "Terbium"),
            Map.entry("zh", "铽"),
            Map.entry("ru", "Тербий"),
            Map.entry("jp", "テルビウム")
        ),
        158.93,
        1.20,
        "[Xe] 4f^9 6s^2",
        1629,  // 1356 °C → 1629 K
        3503,  // 3230 °C → 3503 K
        new byte[]{3},
        -2.30,
        Map.ofEntries(
            Map.entry("de", "Lanthanoid"),
            Map.entry("en", "Lanthanide"),
            Map.entry("fr", "Lanthanoïde"),
            Map.entry("zh", "镧系元素"),
            Map.entry("ru", "Лантаноид"),
            Map.entry("jp", "ランタノイド")
        )
    );

    private final static ChemicalElement DYSPROSIUM = new ChemicalElement(
        (byte) 66,
        "Dy",
        Map.ofEntries(
            Map.entry("de", "Dysprosium"),
            Map.entry("en", "Dysprosium"),
            Map.entry("fr", "Dysprosium"),
            Map.entry("zh", "镝"),
            Map.entry("ru", "Диспрозий"),
            Map.entry("jp", "ジスプロシウム")
        ),
        162.50,
        1.22,
        "[Xe] 4f^10 6s^2",
        1685,  // 1412 °C → 1685 K
        2840,  // 2567 °C → 2840 K
        new byte[]{3},
        -2.29,
        Map.ofEntries(
            Map.entry("de", "Lanthanoid"),
            Map.entry("en", "Lanthanide"),
            Map.entry("fr", "Lanthanoïde"),
            Map.entry("zh", "镧系元素"),
            Map.entry("ru", "Лантаноид"),
            Map.entry("jp", "ランタノイド")
        )
    );

    private final static ChemicalElement HOLMIUM = new ChemicalElement(
        (byte) 67,
        "Ho",
        Map.ofEntries(
            Map.entry("de", "Holmium"),
            Map.entry("en", "Holmium"),
            Map.entry("fr", "Holmium"),
            Map.entry("zh", "钬"),
            Map.entry("ru", "Гольмий"),
            Map.entry("jp", "ホルミウム")
        ),
        164.93,
        1.23,
        "[Xe] 4f^11 6s^2",
        1747,  // 1474 °C → 1747 K
        2973,  // 2700 °C → 2973 K
        new byte[]{3},
        -2.33,
        Map.ofEntries(
            Map.entry("de", "Lanthanoid"),
            Map.entry("en", "Lanthanide"),
            Map.entry("fr", "Lanthanoïde"),
            Map.entry("zh", "镧系元素"),
            Map.entry("ru", "Лантаноид"),
            Map.entry("jp", "ランタノイド")
        )
    );

    private final static ChemicalElement ERBIUM = new ChemicalElement(
        (byte) 68,
        "Er",
        Map.ofEntries(
            Map.entry("de", "Erbium"),
            Map.entry("en", "Erbium"),
            Map.entry("fr", "Erbium"),
            Map.entry("zh", "铒"),
            Map.entry("ru", "Эрбий"),
            Map.entry("jp", "エルビウム")
        ),
        167.26,
        1.24,
        "[Xe] 4f^12 6s^2",
        1802,  // 1529 °C → 1802 K
        3141,  // 2868 °C → 3141 K
        new byte[]{3},
        -2.33,
        Map.ofEntries(
            Map.entry("de", "Lanthanoid"),
            Map.entry("en", "Lanthanide"),
            Map.entry("fr", "Lanthanoïde"),
            Map.entry("zh", "镧系元素"),
            Map.entry("ru", "Лантаноид"),
            Map.entry("jp", "ランタノイド")
        )
    );

    private final static ChemicalElement THULIUM = new ChemicalElement(
        (byte) 69,
        "Tm",
        Map.ofEntries(
            Map.entry("de", "Thulium"),
            Map.entry("en", "Thulium"),
            Map.entry("fr", "Thulium"),
            Map.entry("zh", "铥"),
            Map.entry("ru", "Тулий"),
            Map.entry("jp", "ツリウム")
        ),
        168.93,
        1.25,
        "[Xe] 4f^13 6s^2",
        1818,  // 1545 °C → 1818 K
        2223,  // 1950 °C → 2223 K
        new byte[]{3},
        -2.31,
        Map.ofEntries(
            Map.entry("de", "Lanthanoid"),
            Map.entry("en", "Lanthanide"),
            Map.entry("fr", "Lanthanoïde"),
            Map.entry("zh", "镧系元素"),
            Map.entry("ru", "Лантаноид"),
            Map.entry("jp", "ランタノイド")
        )
    );

    private final static ChemicalElement YTTERBIUM = new ChemicalElement(
        (byte) 70,
        "Yb",
        Map.ofEntries(
            Map.entry("de", "Ytterbium"),
            Map.entry("en", "Ytterbium"),
            Map.entry("fr", "Ytterbium"),
            Map.entry("zh", "镱"),
            Map.entry("ru", "Иттербий"),
            Map.entry("jp", "イッテルビウム")
        ),
        173.05,
        1.10,
        "[Xe] 4f^14 6s^2",
        1097,  // 824 °C → 1097 K
        1469,  // 1196 °C → 1469 K
        new byte[]{2, 3},
        -2.20,
        Map.ofEntries(
            Map.entry("de", "Lanthanoid"),
            Map.entry("en", "Lanthanide"),
            Map.entry("fr", "Lanthanoïde"),
            Map.entry("zh", "镧系元素"),
            Map.entry("ru", "Лантаноид"),
            Map.entry("jp", "ランタノイド")
        )
    );

    private final static ChemicalElement LUTETIUM = new ChemicalElement(
        (byte) 71,
        "Lu",
        Map.ofEntries(
            Map.entry("de", "Lutetium"),
            Map.entry("en", "Lutetium"),
            Map.entry("fr", "Lutétium"),
            Map.entry("zh", "镥"),
            Map.entry("ru", "Лютеций"),
            Map.entry("jp", "ルテチウム")
        ),
        174.97,
        1.27,
        "[Xe] 4f^14 5d^1 6s^2",
        1936,  // 1663 °C → 1936 K
        3675,  // 3402 °C → 3675 K
        new byte[]{3},
        -2.25,
        Map.ofEntries(
            Map.entry("de", "Lanthanoid"),
            Map.entry("en", "Lanthanide"),
            Map.entry("fr", "Lanthanoïde"),
            Map.entry("zh", "镧系元素"),
            Map.entry("ru", "Лантаноид"),
            Map.entry("jp", "ランタノイド")
        )
    );

    private final static ChemicalElement HAFNIUM = new ChemicalElement(
        (byte) 72,
        "Hf",
        Map.ofEntries(
            Map.entry("de", "Hafnium"),
            Map.entry("en", "Hafnium"),
            Map.entry("fr", "Hafnium"),
            Map.entry("zh", "铪"),
            Map.entry("ru", "Гафний"),
            Map.entry("jp", "ハフニウム")
        ),
        178.49,
        1.30,
        "[Xe] 4f^14 5d^2 6s^2",
        2506,  // 2233 °C → 2506 K
        4876,  // 4603 °C → 4876 K
        new byte[]{4},
        -1.70,
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition Metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement TANTALUM = new ChemicalElement(
        (byte) 73,
        "Ta",
        Map.ofEntries(
            Map.entry("de", "Tantal"),
            Map.entry("en", "Tantalum"),
            Map.entry("fr", "Tantale"),
            Map.entry("zh", "钽"),
            Map.entry("ru", "Тантал"),
            Map.entry("jp", "タンタル")
        ),
        180.95,
        1.5,
        "[Xe] 4f^14 5d^3 6s^2",
        3290,  // 3017 °C → 3290 K
        5731,  // 5458 °C → 5731 K
        new byte[]{5},
        -0.12,
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition Metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement TUNGSTEN = new ChemicalElement(
        (byte) 74,
        "W",
        Map.ofEntries(
            Map.entry("de", "Wolfram"),
            Map.entry("en", "Tungsten"),
            Map.entry("fr", "Tungstène"),
            Map.entry("zh", "钨"),
            Map.entry("ru", "Вольфрам"),
            Map.entry("jp", "タングステン")
        ),
        183.84,
        2.36,
        "[Xe] 4f^14 5d^4 6s^2",
        3695,  // 3422 °C → 3695 K
        5828,  // 5555 °C → 5828 K
        new byte[]{6, 5, 4, 3, 2},
        0.12,
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition Metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement RHENIUM = new ChemicalElement(
        (byte) 75,
        "Re",
        Map.ofEntries(
            Map.entry("de", "Rhenium"),
            Map.entry("en", "Rhenium"),
            Map.entry("fr", "Rhénium"),
            Map.entry("zh", "铼"),
            Map.entry("ru", "Рений"),
            Map.entry("jp", "レニウム")
        ),
        186.21,
        1.9,
        "[Xe] 4f^14 5d^5 6s^2",
        3459,  // 3186 °C → 3459 K
        5870,  // 5596 °C → 5870 K
        new byte[]{7, 6, 4, 2},
        0.37,
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition Metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement OSMIUM = new ChemicalElement(
        (byte) 76,
        "Os",
        Map.ofEntries(
            Map.entry("de", "Osmium"),
            Map.entry("en", "Osmium"),
            Map.entry("fr", "Osmium"),
            Map.entry("zh", "锇"),
            Map.entry("ru", "Осмий"),
            Map.entry("jp", "オスミウム")
        ),
        190.23,
        2.2,
        "[Xe] 4f^14 5d^6 6s^2",
        3306,  // 3033 °C → 3306 K
        5285,  // 5012 °C → 5285 K
        new byte[]{8, 6, 4, 3, 2},
        0.40,
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition Metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement IRIDIUM = new ChemicalElement(
        (byte) 77,
        "Ir",
        Map.ofEntries(
            Map.entry("de", "Iridium"),
            Map.entry("en", "Iridium"),
            Map.entry("fr", "Iridium"),
            Map.entry("zh", "铱"),
            Map.entry("ru", "Иридий"),
            Map.entry("jp", "イリジウム")
        ),
        192.22,
        2.20,
        "[Xe] 4f^14 5d^7 6s^2",
        2739,  // 2466 °C → 2739 K
        4701,  // 4428 °C → 4701 K
        new byte[]{6, 4, 3},
        0.56,
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition Metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement PLATINUM = new ChemicalElement(
        (byte) 78,
        "Pt",
        Map.ofEntries(
            Map.entry("de", "Platin"),
            Map.entry("en", "Platinum"),
            Map.entry("fr", "Platine"),
            Map.entry("zh", "铂"),
            Map.entry("ru", "Платина"),
            Map.entry("jp", "プラチナ")
        ),
        195.08,
        2.28,
        "[Xe] 4f^14 5d^9 6s^1",
        2041,  // 1768 °C → 2041 K
        4098,  // 3825 °C → 4098 K
        new byte[]{4, 2},
        1.18,
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition Metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement GOLD = new ChemicalElement(
        (byte) 79,
        "Au",
        Map.ofEntries(
            Map.entry("de", "Gold"),
            Map.entry("en", "Gold"),
            Map.entry("fr", "Or"),
            Map.entry("zh", "金"),
            Map.entry("ru", "Золото"),
            Map.entry("jp", "金")
        ),
        196.97,
        2.54,
        "[Xe] 4f^14 5d^10 6s^1",
        1337,  // 1064 °C → 1337 K
        3132,  // 2856 °C → 3132 K
        new byte[]{3, 1},
        1.50,
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition Metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement MERCURY = new ChemicalElement(
        (byte) 80,
        "Hg",
        Map.ofEntries(
            Map.entry("de", "Quecksilber"),
            Map.entry("en", "Mercury"),
            Map.entry("fr", "Mercure"),
            Map.entry("zh", "汞"),
            Map.entry("ru", "Ртуть"),
            Map.entry("jp", "水銀")
        ),
        200.59,
        2.00,
        "[Xe] 4f^14 5d^10 6s^2",
        234,   // -39 °C → 234 K
        630,   // 357 °C → 630 K
        new byte[]{2, 1},
        0.85,
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition Metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement THALLIUM = new ChemicalElement(
        (byte) 81,
        "Tl",
        Map.ofEntries(
            Map.entry("de", "Thallium"),
            Map.entry("en", "Thallium"),
            Map.entry("fr", "Thallium"),
            Map.entry("zh", "铊"),
            Map.entry("ru", "Таллий"),
            Map.entry("jp", "タリウム")
        ),
        204.38,
        1.62,
        "[Xe] 4f^14 5d^10 6s^2 6p^1",
        577,   // 304 °C → 577 K
        1746,  // 1473 °C → 1746 K
        new byte[]{3, 1},
        0.73,
        Map.ofEntries(
            Map.entry("de", "Post-Übergangsmetall"),
            Map.entry("en", "Post-Transition Metal"),
            Map.entry("fr", "Métal post-transitionnel"),
            Map.entry("zh", "后过渡金属"),
            Map.entry("ru", "Постпереходный металл"),
            Map.entry("jp", "後遷移金属")
        )
    );

    private final static ChemicalElement LEAD = new ChemicalElement(
        (byte) 82,
        "Pb",
        Map.ofEntries(
            Map.entry("de", "Blei"),
            Map.entry("en", "Lead"),
            Map.entry("fr", "Plomb"),
            Map.entry("zh", "铅"),
            Map.entry("ru", "Свинец"),
            Map.entry("jp", "鉛")
        ),
        207.2,
        2.33,
        "[Xe] 4f^14 5d^10 6s^2 6p^2",
        600,    // 327 °C → 600 K
        2022,   // 1749 °C → 2022 K
        new byte[]{4, 2},
        -0.13,
        Map.ofEntries(
            Map.entry("de", "Post-Übergangsmetall"),
            Map.entry("en", "Post-Transition Metal"),
            Map.entry("fr", "Métal post-transitionnel"),
            Map.entry("zh", "后过渡金属"),
            Map.entry("ru", "Постпереходный металл"),
            Map.entry("jp", "後遷移金属")
        )
    );

    private final static ChemicalElement BISMUTH = new ChemicalElement(
        (byte) 83,
        "Bi",
        Map.ofEntries(
            Map.entry("de", "Wismut"),
            Map.entry("en", "Bismuth"),
            Map.entry("fr", "Bismuth"),
            Map.entry("zh", "铋"),
            Map.entry("ru", "Висмут"),
            Map.entry("jp", "ビスマス")
        ),
        208.98,
        2.02,
        "[Xe] 4f^14 5d^10 6s^2 6p^3",
        544,    // 271 °C → 544 K
        1837,   // 1564 °C → 1837 K
        new byte[]{5, 3},
        0.32,
        Map.ofEntries(
            Map.entry("de", "Post-Übergangsmetall"),
            Map.entry("en", "Post-Transition Metal"),
            Map.entry("fr", "Métal post-transitionnel"),
            Map.entry("zh", "后过渡金属"),
            Map.entry("ru", "Постпереходный металл"),
            Map.entry("jp", "後遷移金属")
        )
    );

    private final static ChemicalElement POLONIUM = new ChemicalElement(
        (byte) 84,
        "Po",
        Map.ofEntries(
            Map.entry("de", "Polonium"),
            Map.entry("en", "Polonium"),
            Map.entry("fr", "Polonium"),
            Map.entry("zh", "钋"),
            Map.entry("ru", "Полоний"),
            Map.entry("jp", "ポロニウム")
        ),
        209,
        2.00,
        "[Xe] 4f^14 5d^10 6s^2 6p^4",
        527,    // 254 °C → 527 K
        1235,   // 962 °C → 1235 K
        new byte[]{6, 4, 2},
        0.89,
        Map.ofEntries(
            Map.entry("de", "Halbmetall"),  // Korrektur hier
            Map.entry("en", "Metalloid"),
            Map.entry("fr", "Métalloïde"),
            Map.entry("zh", "类金属"),
            Map.entry("ru", "Металлоид"),
            Map.entry("jp", "準金属")
        )
    );

    private final static ChemicalElement ASTATINE = new ChemicalElement(
        (byte) 85,
        "At",
        Map.ofEntries(
            Map.entry("de", "Astat"),
            Map.entry("en", "Astatine"),
            Map.entry("fr", "Astate"),
            Map.entry("zh", "砹"),
            Map.entry("ru", "Астат"),
            Map.entry("jp", "アスタチン")
        ),
        210,
        2.20,
        "[Xe] 4f^14 5d^10 6s^2 6p^5",
        575,    // 302 °C → 575 K
        610,    // 337 °C → 610 K
        new byte[]{-1, 1, 3, 5, 7},
        0.27,
        Map.ofEntries(
            Map.entry("de", "Halogen"),
            Map.entry("en", "Halogen"),
            Map.entry("fr", "Halogène"),
            Map.entry("zh", "卤素"),
            Map.entry("ru", "Галоген"),
            Map.entry("jp", "ハロゲン")
        )
    );

    private final static ChemicalElement RADON = new ChemicalElement(
        (byte) 86,
        "Rn",
        Map.ofEntries(
            Map.entry("de", "Radon"),
            Map.entry("en", "Radon"),
            Map.entry("fr", "Radon"),
            Map.entry("zh", "氡"),
            Map.entry("ru", "Радон"),
            Map.entry("jp", "ラドン")
        ),
        222,
        Double.NaN, // Elektronegativität unbekannt → Double.NaN korrekt
        "[Xe] 4f^14 5d^10 6s^2 6p^6",
        202, // -71 °C → 202 K
        211, // -62 °C → 211 K
        new byte[]{0}, // Oxidationszahl für Edelgas meist 0
        Double.NaN, // Kein Standardelektrodenpotential
        Map.ofEntries(
            Map.entry("de", "Edelgas"),
            Map.entry("en", "Noble Gas"),
            Map.entry("fr", "Gaz noble"),
            Map.entry("zh", "惰性气体"),
            Map.entry("ru", "Благородный газ"),
            Map.entry("jp", "希ガス")
        )
    );

    private final static ChemicalElement FRANCIUM = new ChemicalElement(
        (byte) 87,
        "Fr",
        Map.ofEntries(
            Map.entry("de", "Francium"),
            Map.entry("en", "Francium"),
            Map.entry("fr", "Francium"),
            Map.entry("zh", "钫"),
            Map.entry("ru", "Франций"),
            Map.entry("jp", "フランシウム")
        ),
        223,
        0.79,
        "[Rn] 7s^1",
        300,  // 27 °C → 300 K
        950,  // 677 °C → 950 K
        new byte[]{1},
        Double.NaN, // kein verlässliches Elektrodenpotential
        Map.ofEntries(
            Map.entry("de", "Alkalimetall"),
            Map.entry("en", "Alkali Metal"),
            Map.entry("fr", "Métal alcalin"),
            Map.entry("zh", "碱金属"),
            Map.entry("ru", "Щелочной металл"),
            Map.entry("jp", "アルカリ金属")
        )
    );

    private final static ChemicalElement RADIUM = new ChemicalElement(
        (byte) 88,
        "Ra",
        Map.ofEntries(
            Map.entry("de", "Radium"),
            Map.entry("en", "Radium"),
            Map.entry("fr", "Radium"),
            Map.entry("zh", "镭"),
            Map.entry("ru", "Радий"),
            Map.entry("jp", "ラジウム")
        ),
        226,
        0.90,
        "[Rn] 7s^2",
        973,  // 700 °C → 973 K
        2010, // 1737 °C → 2010 K
        new byte[]{2},
        Double.NaN,  // kein gesicherter Wert
        Map.ofEntries(
            Map.entry("de", "Erdalkalimetall"),
            Map.entry("en", "Alkaline Earth Metal"),
            Map.entry("fr", "Métal alcalino-terreux"),
            Map.entry("zh", "碱土金属"),
            Map.entry("ru", "Щелочноземельный металл"),
            Map.entry("jp", "アルカリ土類金属")
        )
    );

    private final static ChemicalElement ACTINIUM = new ChemicalElement(
        (byte) 89,
        "Ac",
        Map.ofEntries(
            Map.entry("de", "Actinium"),
            Map.entry("en", "Actinium"),
            Map.entry("fr", "Actinium"),
            Map.entry("zh", "锕"),
            Map.entry("ru", "Актиний"),
            Map.entry("jp", "アクチニウム")
        ),
        227,
        Double.NaN,
        "[Rn] 6d^1 7s^2",
        1323, // 1050 °C → 1323 K
        3573, // 3200 °C → 3573 K
        new byte[]{3},
        Double.NaN,
        Map.ofEntries(
            Map.entry("de", "Actinoid"),
            Map.entry("en", "Actinide"),
            Map.entry("fr", "Actinide"),
            Map.entry("zh", "锕系元素"),
            Map.entry("ru", "Актиноид"),
            Map.entry("jp", "アクチニド")
        )
);

    private final static ChemicalElement THORIUM = new ChemicalElement(
        (byte) 90,
        "Th",
        Map.ofEntries(
            Map.entry("de", "Thorium"),
            Map.entry("en", "Thorium"),
            Map.entry("fr", "Thorium"),
            Map.entry("zh", "钍"),
            Map.entry("ru", "Торий"),
            Map.entry("jp", "トリウム")
        ),
        232.04,
        Double.NaN,
        "[Rn] 6d^2 7s^2",
        2023, // 1750 °C → 2023 K
        5050, // 4788 °C → 5050 K
        new byte[]{4},
        Double.NaN,
        Map.ofEntries(
            Map.entry("de", "Actinoid"),
            Map.entry("en", "Actinide"),
            Map.entry("fr", "Actinide"),
            Map.entry("zh", "锕系元素"),
            Map.entry("ru", "Актиноид"),
            Map.entry("jp", "アクチニド")
        )
    );

    private final static ChemicalElement PROTACTINIUM = new ChemicalElement(
        (byte) 91,
        "Pa",
        Map.ofEntries(
            Map.entry("de", "Protactinium"),
            Map.entry("en", "Protactinium"),
            Map.entry("fr", "Protactinium"),
            Map.entry("zh", "镤"),
            Map.entry("ru", "Протактиний"),
            Map.entry("jp", "プロトアクチニウム")
        ),
        231.04,
        Double.NaN,
        "[Rn] 5f^2 6d^1 7s^2",
        1845, // 1572 °C → 1845 K
        4273, // 4000 °C → 4273 K
        new byte[]{5, 4},
        Double.NaN,
        Map.ofEntries(
            Map.entry("de", "Actinoid"),
            Map.entry("en", "Actinide"),
            Map.entry("fr", "Actinide"),
            Map.entry("zh", "锕系元素"),
            Map.entry("ru", "Актиноид"),
            Map.entry("jp", "アクチニド")
        )
    );

    private final static ChemicalElement URANIUM = new ChemicalElement(
        (byte) 92,
        "U",
        Map.ofEntries(
            Map.entry("de", "Uran"),
            Map.entry("en", "Uranium"),
            Map.entry("fr", "Uranium"),
            Map.entry("zh", "铀"),
            Map.entry("ru", "Уран"),
            Map.entry("jp", "ウラン")
        ),
        238.03,
        Double.NaN,
        "[Rn] 5f^3 6d^1 7s^2",
        1408, // Schmelzpunkt in K (1135 °C)
        4404, // Siedepunkt in K (4131 °C)
        new byte[]{6, 5, 4, 3},
        Double.NaN,
        Map.ofEntries(
            Map.entry("de", "Actinoid"),
            Map.entry("en", "Actinide"),
            Map.entry("fr", "Actinide"),
            Map.entry("zh", "锕系元素"),
            Map.entry("ru", "Актиноид"),
            Map.entry("jp", "アクチニド")
        )
    );

    private final static ChemicalElement NEPTUNIUM = new ChemicalElement(
        (byte) 93,
        "Np",
        Map.ofEntries(
            Map.entry("de", "Neptunium"),
            Map.entry("en", "Neptunium"),
            Map.entry("fr", "Neptunium"),
            Map.entry("zh", "镎"),
            Map.entry("ru", "Нептуний"),
            Map.entry("jp", "ネプツニウム")
        ),
        237,
        Double.NaN,
        "[Rn] 5f^4 6d^1 7s^2",
        917,  // 644 °C
        4273, // 4000 °C
        new byte[]{6, 5, 4, 3},
        Double.NaN,
        Map.ofEntries(
            Map.entry("de", "Actinoid"),
            Map.entry("en", "Actinide"),
            Map.entry("fr", "Actinide"),
            Map.entry("zh", "锕系元素"),
            Map.entry("ru", "Актиноид"),
            Map.entry("jp", "アクチニド")
        )
    );

    private final static ChemicalElement PLUTONIUM = new ChemicalElement(
        (byte) 94,
        "Pu",
        Map.ofEntries(
            Map.entry("de", "Plutonium"),
            Map.entry("en", "Plutonium"),
            Map.entry("fr", "Plutonium"),
            Map.entry("zh", "钚"),
            Map.entry("ru", "Плутоний"),
            Map.entry("jp", "プルトニウム")
        ),
        244,
        Double.NaN,             // Elektronegativität: keine gesicherten Werte
        "[Rn] 5f^6 7s^2",
        913,                   // 640 °C in K = 913 K
        3501,                  // 3228 °C in K = 3501 K
        new byte[]{6, 5, 4, 3},
        Double.NaN,            // Elektrochemisches Potential unbekannt
        Map.ofEntries(
            Map.entry("de", "Actinoid"),
            Map.entry("en", "Actinide"),
            Map.entry("fr", "Actinide"),
            Map.entry("zh", "锕系元素"),
            Map.entry("ru", "Актиноид"),
            Map.entry("jp", "アクチニド")
        )
    );

    private final static ChemicalElement AMERICIUM = new ChemicalElement(
        (byte) 95,
        "Am",
        Map.ofEntries(
            Map.entry("de", "Americium"),
            Map.entry("en", "Americium"),
            Map.entry("fr", "Américium"),
            Map.entry("zh", "镅"),
            Map.entry("ru", "Америций"),
            Map.entry("jp", "アメリシウム")
        ),
        243,
        Double.NaN,            // Elektronegativität unbekannt
        "[Rn] 5f^7 7s^2",
        1449,                  // 1176 °C = 1449 K
        2880,                  // 2607 °C = 2880 K
        new byte[]{6, 5, 4, 3},
        Double.NaN,            // Elektrochemisches Potential unbekannt
        Map.ofEntries(
            Map.entry("de", "Actinoid"),
            Map.entry("en", "Actinide"),
            Map.entry("fr", "Actinide"),
            Map.entry("zh", "锕系元素"),
            Map.entry("ru", "Актиноид"),
            Map.entry("jp", "アクチニド")
        )
    );

    private final static ChemicalElement CURIUM = new ChemicalElement(
        (byte) 96,
        "Cm",
        Map.ofEntries(
            Map.entry("de", "Curium"),
            Map.entry("en", "Curium"),
            Map.entry("fr", "Curium"),
            Map.entry("zh", "锔"),
            Map.entry("ru", "Кюрий"),
            Map.entry("jp", "キュリウム")
        ),
        247,
        Double.NaN,            // Elektronegativität unbekannt
        "[Rn] 5f^7 6d^1 7s^2",
        1613,                  // 1340 °C = 1613 K
        3383,                  // 3110 °C = 3383 K
        new byte[]{6, 5, 4, 3},
        Double.NaN,            // Elektrochemisches Potential unbekannt
        Map.ofEntries(
            Map.entry("de", "Actinoid"),
            Map.entry("en", "Actinide"),
            Map.entry("fr", "Actinide"),
            Map.entry("zh", "锕系元素"),
            Map.entry("ru", "Актиноид"),
            Map.entry("jp", "アクチニド")
        )
    );

    private final static ChemicalElement BERKELIUM = new ChemicalElement(
        (byte) 97,
        "Bk",
        Map.ofEntries(
            Map.entry("de", "Berkelium"),
            Map.entry("en", "Berkelium"),
            Map.entry("fr", "Berkélium"),
            Map.entry("zh", "锫"),
            Map.entry("ru", "Берклий"),
            Map.entry("jp", "バークリウム")
        ),
        247,
        Double.NaN,            // Elektronegativität unbekannt
        "[Rn] 5f^9 7s^2",
        1259,                  // 986 °C = 1259 K
        2900,                  // ca. 2627 °C = 2900 K
        new byte[]{4, 3},
        Double.NaN,            // Elektrochemisches Potential unbekannt
        Map.ofEntries(
            Map.entry("de", "Actinoid"),
            Map.entry("en", "Actinide"),
            Map.entry("fr", "Actinide"),
            Map.entry("zh", "锕系元素"),
            Map.entry("ru", "Актиноид"),
            Map.entry("jp", "アクチニド")
        )
    );

    private final static ChemicalElement CALIFORNIUM = new ChemicalElement(
        (byte) 98,
        "Cf",
        Map.ofEntries(
            Map.entry("de", "Californium"),
            Map.entry("en", "Californium"),
            Map.entry("fr", "Californium"),
            Map.entry("zh", "锎"),
            Map.entry("ru", "Калифорний"),
            Map.entry("jp", "カリホルニウム")
        ),
        251,
        Double.NaN, // Elektronegativität unbekannt
        "[Rn] 5f^10 7s^2",
        Integer.MIN_VALUE, // Schmelzpunkt unbekannt
        Integer.MIN_VALUE, // Siedepunkt unbekannt
        new byte[]{4, 3},
        Double.NaN, // Elektrodenpotential unbekannt
        Map.ofEntries(
            Map.entry("de", "Actinoid"),
            Map.entry("en", "Actinide"),
            Map.entry("fr", "Actinide"),
            Map.entry("zh", "锕系元素"),
            Map.entry("ru", "Актиноид"),
            Map.entry("jp", "アクチニド")
        )
    );

    private final static ChemicalElement EINSTEINIUM = new ChemicalElement(
        (byte) 99,
        "Es",
        Map.ofEntries(
            Map.entry("de", "Einsteinium"),
            Map.entry("en", "Einsteinium"),
            Map.entry("fr", "Einsteinium"),
            Map.entry("zh", "锿"),
            Map.entry("ru", "Эйнштейний"),
            Map.entry("jp", "アインシュタイニウム")
        ),
        252,
        Double.NaN,
        "[Rn] 5f^11 7s^2",
        Integer.MIN_VALUE,
        Integer.MIN_VALUE,
        new byte[]{3},
        Double.NaN,
        Map.ofEntries(
            Map.entry("de", "Actinoid"),
            Map.entry("en", "Actinide"),
            Map.entry("fr", "Actinide"),
            Map.entry("zh", "锕系元素"),
            Map.entry("ru", "Актиноид"),
            Map.entry("jp", "アクチニド")
        )
    );

    private final static ChemicalElement FERMIUM = new ChemicalElement(
        (byte) 100,
        "Fm",
        Map.ofEntries(
            Map.entry("de", "Fermium"),
            Map.entry("en", "Fermium"),
            Map.entry("fr", "Fermium"),
            Map.entry("zh", "镄"),
            Map.entry("ru", "Фермий"),
            Map.entry("jp", "フェルミウム")
        ),
        257,
        Double.NaN,
        "[Rn] 5f^12 7s^2",
        Integer.MIN_VALUE,
        Integer.MIN_VALUE,
        new byte[]{3},
        Double.NaN,
        Map.ofEntries(
            Map.entry("de", "Actinoid"),
            Map.entry("en", "Actinide"),
            Map.entry("fr", "Actinide"),
            Map.entry("zh", "锕系元素"),
            Map.entry("ru", "Актиноид"),
            Map.entry("jp", "アクチニド")
        )
    );

    private final static ChemicalElement MANDELEVIUM = new ChemicalElement(
        (byte) 101,
        "Md",
        Map.ofEntries(
            Map.entry("de", "Mendelevium"),
            Map.entry("en", "Mendelevium"),
            Map.entry("fr", "Mendélévium"),
            Map.entry("zh", "门捷列夫"),
            Map.entry("ru", "Менделеевий"),
            Map.entry("jp", "メンデレビウム")
        ),
        258,
        Double.NaN,
        "[Rn] 5f^13 7s^2",
        Integer.MIN_VALUE,
        Integer.MIN_VALUE,
        new byte[]{3},
        Double.NaN,
        Map.ofEntries(
            Map.entry("de", "Actinoid"),
            Map.entry("en", "Actinide"),
            Map.entry("fr", "Actinide"),
            Map.entry("zh", "锕系元素"),
            Map.entry("ru", "Актиноид"),
            Map.entry("jp", "アクチニド")
        )
    );

    private final static ChemicalElement NOBELIUM = new ChemicalElement(
        (byte) 102,
        "No",
        Map.ofEntries(
            Map.entry("de", "Nobelium"),
            Map.entry("en", "Nobelium"),
            Map.entry("fr", "Nobélium"),
            Map.entry("zh", "诺贝利"),
            Map.entry("ru", "Нобелий"),
            Map.entry("jp", "ノーベリウム")
        ),
        259,
        Double.NaN,
        "[Rn] 5f^14 7s^2",
        827,                 // Schmelzpunkt in K (554 °C)
        Integer.MIN_VALUE,    // Siedepunkt unbekannt
        new byte[]{2, 3},
        Double.NaN,
        Map.ofEntries(
            Map.entry("de", "Actinoid"),
            Map.entry("en", "Actinide"),
            Map.entry("fr", "Actinide"),
            Map.entry("zh", "锕系元素"),
            Map.entry("ru", "Актиноид"),
            Map.entry("jp", "アクチニド")
        )
    );

    private final static ChemicalElement LAWRENCIUM = new ChemicalElement(
        (byte) 103,
        "Lr",
        Map.ofEntries(
            Map.entry("de", "Lawrencium"),
            Map.entry("en", "Lawrencium"),
            Map.entry("fr", "Lawrencium"),
            Map.entry("zh", "劳伦锶"),
            Map.entry("ru", "Лоуренсий"),
            Map.entry("jp", "ローレンシウム")
        ),
        262,
        Double.NaN, // Elektronegativität unbekannt
        "[Rn] 5f^14 6d^1 7s^2",
        1627,
        3327,
        new byte[]{3},
        Double.NaN, // Elektrodenpotential unbekannt
        Map.ofEntries(
            Map.entry("de", "Actinoid"),
            Map.entry("en", "Actinide"),
            Map.entry("fr", "Actinide"),
            Map.entry("zh", "锕系元素"),
            Map.entry("ru", "Актиноид"),
            Map.entry("jp", "アクチニド")
        )
    );

    private final static ChemicalElement RUTHERFORDIUM = new ChemicalElement(
        (byte) 104,
        "Rf",
        Map.ofEntries(
            Map.entry("de", "Rutherfordium"),
            Map.entry("en", "Rutherfordium"),
            Map.entry("fr", "Rutherfordium"),
            Map.entry("zh", "卢瑟福锶"),
            Map.entry("ru", "Резерфордий"),
            Map.entry("jp", "ラザフォージウム")
        ),
        267,
        Double.NaN,
        "[Rn] 5f^14 6d^2 7s^2",
        2410,
        5800,
        new byte[]{4},
        Double.NaN,
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition Metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement DUBNIUM = new ChemicalElement(
        (byte) 105,
        "Db",
        Map.ofEntries(
            Map.entry("de", "Dubnium"),
            Map.entry("en", "Dubnium"),
            Map.entry("fr", "Dubnium"),
            Map.entry("zh", "杜布尼锶"),
            Map.entry("ru", "Дубний"),
            Map.entry("jp", "ドブニウム")
        ),
        270,
        Double.NaN,
        "[Rn] 5f^14 6d^3 7s^2",
        2830,
        5850,
        new byte[]{5},
        Double.NaN,
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition Metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement SEABORGIUM = new ChemicalElement(
        (byte) 106,
        "Sg",
        Map.ofEntries(
            Map.entry("de", "Seaborgium"),
            Map.entry("en", "Seaborgium"),
            Map.entry("fr", "Seaborgium"),
            Map.entry("zh", "西博锶"),
            Map.entry("ru", "Сиборгий"),
            Map.entry("jp", "シーボーギウム")
        ),
        271,
        Double.NaN,
        "[Rn] 5f^14 6d^4 7s^2",
        2900,
        5860,
        new byte[]{6},
        Double.NaN,
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition Metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement BOHRIUM = new ChemicalElement(
        (byte) 107,
        "Bh",
        Map.ofEntries(
            Map.entry("de", "Bohrium"),
            Map.entry("en", "Bohrium"),
            Map.entry("fr", "Bohrium"),
            Map.entry("zh", "钅博锶"),
            Map.entry("ru", "Борий"),
            Map.entry("jp", "ボーリウム")
        ),
        270,
        Double.NaN,
        "[Rn] 5f^14 6d^5 7s^2",
        2800,
        5780,
        new byte[]{7},
        Double.NaN,
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition Metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement HASSIUM = new ChemicalElement(
        (byte) 108,
        "Hs",
        Map.ofEntries(
            Map.entry("de", "Hassium"),
            Map.entry("en", "Hassium"),
            Map.entry("fr", "Hassium"),
            Map.entry("zh", "哈锶"),
            Map.entry("ru", "Хассий"),
            Map.entry("jp", "ハッシウム")
        ),
        277,
        Double.NaN,
        "[Rn] 5f^14 6d^6 7s^2",
        2870,
        5800,
        new byte[]{8},
        Double.NaN,
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition Metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement MEITNERIUM = new ChemicalElement(
        (byte) 109,
        "Mt",
        Map.ofEntries(
            Map.entry("de", "Meitnerium"),
            Map.entry("en", "Meitnerium"),
            Map.entry("fr", "Meitnérium"),
            Map.entry("zh", "迈特纳铱"),
            Map.entry("ru", "Мейтнерий"),
            Map.entry("jp", "マイトネリウム")
        ),
        278,
        Double.NaN,
        "[Rn] 5f^14 6d^7 7s^2",
        2900,
        5700,
        new byte[]{},  // keine gesicherten Oxidationszahlen
        Double.NaN,
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition Metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement DARMSTADTIUM = new ChemicalElement(
        (byte) 110,
        "Ds",
        Map.ofEntries(
            Map.entry("de", "Darmstadtium"),
            Map.entry("en", "Darmstadtium"),
            Map.entry("fr", "Darmstadtium"),
            Map.entry("zh", "达姆斯塔特铽"),
            Map.entry("ru", "Дармштадтий"),
            Map.entry("jp", "ダームシュタチウム")
        ),
        281,
        Double.NaN,
        "[Rn] 5f^14 6d^8 7s^2",
        2800,
        5700,
        new byte[]{},  // keine gesicherten Oxidationszahlen
        Double.NaN,
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition Metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement ROENTGENIUM = new ChemicalElement(
        (byte) 111,
        "Rg",
        Map.ofEntries(
            Map.entry("de", "Roentgenium"),
            Map.entry("en", "Roentgenium"),
            Map.entry("fr", "Roentgenium"),
            Map.entry("zh", "伦琴镆"),
            Map.entry("ru", "Рентгений"),
            Map.entry("jp", "レントゲニウム")
        ),
        280,
        Double.NaN,
        "[Rn] 5f^14 6d^9 7s^2",
        2800,
        5700,
        new byte[]{},  // keine gesicherten Oxidationszahlen
        Double.NaN,
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition Metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement COPERNICUM = new ChemicalElement(
        (byte) 112,
        "Cn",
        Map.ofEntries(
            Map.entry("de", "Copernicium"),
            Map.entry("en", "Copernicium"),
            Map.entry("fr", "Copernicium"),
            Map.entry("zh", "钅科普"),
            Map.entry("ru", "Коперниций"),
            Map.entry("jp", "コペルニシウム")
        ),
        285,
        Double.NaN,
        "[Rn] 5f^14 6d^10 7s^2",
        2830,
        5770,
        new byte[]{2},  // +2 am wahrscheinlichsten
        Double.NaN,
        Map.ofEntries(
            Map.entry("de", "Übergangsmetall"),
            Map.entry("en", "Transition Metal"),
            Map.entry("fr", "Métal de transition"),
            Map.entry("zh", "过渡金属"),
            Map.entry("ru", "Переходный металл"),
            Map.entry("jp", "遷移金属")
        )
    );

    private final static ChemicalElement NIHONIUM = new ChemicalElement(
        (byte) 113,
        "Nh",
        Map.ofEntries(
            Map.entry("de", "Nihonium"),
            Map.entry("en", "Nihonium"),
            Map.entry("fr", "Nihonium"),
            Map.entry("zh", "镍和"),
            Map.entry("ru", "Нихоний"),
            Map.entry("jp", "ニホニウム")
        ),
        284,
        Double.NaN,
        "[Rn] 5f^14 6d^10 7s^2 7p^1",
        2700,
        4600,
        new byte[]{3},
        Double.NaN,
        Map.ofEntries(
            Map.entry("de", "Post-Übergangsmetall"),
            Map.entry("en", "Post-Transition Metal"),
            Map.entry("fr", "Métal post-transitionnel"),
            Map.entry("zh", "后过渡金属"),
            Map.entry("ru", "Постпереходный металл"),
            Map.entry("jp", "ポスト遷移金属")
        )
    );

    private final static ChemicalElement FLEROVIUM = new ChemicalElement(
        (byte) 114,
        "Fl",
        Map.ofEntries(
            Map.entry("de", "Flerovium"),
            Map.entry("en", "Flerovium"),
            Map.entry("fr", "Flérovium"),
            Map.entry("zh", "弗勒洛维"),
            Map.entry("ru", "Флеровий"),
            Map.entry("jp", "フレロビウム")
        ),
        289,
        Double.NaN,
        "[Rn] 5f^14 6d^10 7s^2 7p^2",
        2000,
        4000,
        new byte[]{2, 4},
        Double.NaN,
        Map.ofEntries(
            Map.entry("de", "Post-Übergangsmetall"),
            Map.entry("en", "Post-Transition Metal"),
            Map.entry("fr", "Métal post-transitionnel"),
            Map.entry("zh", "后过渡金属"),
            Map.entry("ru", "Постпереходный металл"),
            Map.entry("jp", "ポスト遷移金属")
        )
    );

    private final static ChemicalElement MOSCOVIUM = new ChemicalElement(
        (byte) 115,
        "Mc",
        Map.ofEntries(
            Map.entry("de", "Moscovium"),
            Map.entry("en", "Moscovium"),
            Map.entry("fr", "Moscovium"),
            Map.entry("zh", "莫斯科维"),
            Map.entry("ru", "Московий"),
            Map.entry("jp", "モスコビウム")
        ),
        288,
        Double.NaN,
        "[Rn] 5f^14 6d^10 7s^2 7p^3",
        1500,
        3000,
        new byte[]{},
        Double.NaN,
        Map.ofEntries(
            Map.entry("de", "Post-Übergangsmetall"),
            Map.entry("en", "Post-Transition Metal"),
            Map.entry("fr", "Métal post-transitionnel"),
            Map.entry("zh", "后过渡金属"),
            Map.entry("ru", "Постпереходный металл"),
            Map.entry("jp", "ポスト遷移金属")
        )
    );
    
    private final static ChemicalElement LIVERMORIUM = new ChemicalElement(
        (byte) 116,
        "Lv",
        Map.ofEntries(
            Map.entry("de", "Livermorium"),
            Map.entry("en", "Livermorium"),
            Map.entry("fr", "Livermorium"),
            Map.entry("zh", "利弗莫里"),
            Map.entry("ru", "Ливерморий"),
            Map.entry("jp", "リバモリウム")
        ),
        293,
        Double.NaN,
        "[Rn] 5f^14 6d^10 7s^2 7p^4",
        1300,
        2800,
        new byte[]{},  // +2 ist vermutet
        Double.NaN,
        Map.ofEntries(
            Map.entry("de", "Metall"),
            Map.entry("en", "Post-Transition Metal"),
            Map.entry("fr", "Métal post-transitionnel"),
            Map.entry("zh", "后过渡金属"),
            Map.entry("ru", "Постпереходный металл"),
            Map.entry("jp", "ポスト遷移金属")
        )
    );

    private final static ChemicalElement TENNESSINE = new ChemicalElement(
        (byte) 117,
        "Ts",
        Map.ofEntries(
            Map.entry("de", "Tennessin"),
            Map.entry("en", "Tennessine"),
            Map.entry("fr", "Tennessine"),
            Map.entry("zh", "田纳辛"),
            Map.entry("ru", "Теннесин"),
            Map.entry("jp", "テネシン")
        ),
        294,
        Double.NaN,
        "[Rn] 5f^14 6d^10 7s^2 7p^5",
        1200,
        2500,
        new byte[]{}, // Halogen-ähnliche Oxidationszahlen (theoretisch)
        Double.NaN,
        Map.ofEntries(
            Map.entry("de", "Halogen"),
            Map.entry("en", "Halogen"),
            Map.entry("fr", "Halogène"),
            Map.entry("zh", "卤素"),
            Map.entry("ru", "Галоген"),
            Map.entry("jp", "ハロゲン")
        )
    );

    private final static ChemicalElement OGANESSON = new ChemicalElement(
        (byte) 118,
        "Og",
        Map.ofEntries(
            Map.entry("de", "Oganesson"),
            Map.entry("en", "Oganesson"),
            Map.entry("fr", "Oganesson"),
            Map.entry("zh", "奥加尼森"),
            Map.entry("ru", "Оганесон"),
            Map.entry("jp", "オガネソン")
        ),
        294,
        Double.NaN,
        "[Rn] 5f^14 6d^10 7s^2 7p^6",
        123,
        350,
        new byte[]{}, // Oxidationszahlen unbekannt, sehr instabil
        Double.NaN,
        Map.ofEntries(
            Map.entry("de", "Edelgas"),
            Map.entry("en", "Noble Gas"),
            Map.entry("fr", "Gaz noble"),
            Map.entry("zh", "稀有气体"),
            Map.entry("ru", "Благородный газ"),
            Map.entry("jp", "希ガス")
        )
    );

    /**
     * List of all chemical elements in the periodic table.
     * The order is based on the atomic number.
     * The list includes all known elements as of Febuary 2025.
     * The elements are represented as instances of the ChemicalElement class.
     */
    private final static ChemicalElement[] LIST_OF_ELEMENTS = {
        HYDROGEN, HELIUM,
        LITHIUM, BERYLLIUM, BORON, CARBON, NITROGEN, OXYGEN, FLUORINE, NEON,
        SODIUM, MAGNESIUM, ALUMINUM, SILICON, PHOSPHORUS, SULFUR, CHLORINE, ARGON,
        POTASSIUM, CALCIUM, SCANDIUM, TITANIUM, VANADIUM, CHROMIUM, MANGANESE, IRON, COBALT, NICKEL, COPPER, ZINC, GALLIUM, GERMANIUM, ARSENIC, SELENIUM, BROMINE, KRYPTON,
        RUBIDIUM, STRONTIUM, YTTRIUM, ZIRCONIUM, NIOBIUM, MOLYBDENUM, TECHNETIUM, RUTHENIUM, RHODIUM, PALLADIUM, SILVER, CADMIUM, INDIUM, TIN, ANTIMONY, TELLURIUM, IODINE, XENON,
        CESIUM, BARIUM, 
            LANTHANUM, CERIUM, PRASEODYMIUM, NEODYMIUM, PROMETHIUM, SAMARIUM, EUROPIUM, GADOLINIUM, TERBIUM, DYSPROSIUM, HOLMIUM, ERBIUM, THULIUM, YTTERBIUM, LUTETIUM,
        HAFNIUM, TANTALUM, TUNGSTEN, RHENIUM, OSMIUM, IRIDIUM, PLATINUM, GOLD, MERCURY, THALLIUM, LEAD, BISMUTH, POLONIUM, ASTATINE, RADON,
        FRANCIUM, RADIUM,
            ACTINIUM, THORIUM, PROTACTINIUM, URANIUM, NEPTUNIUM, PLUTONIUM, AMERICIUM, CURIUM, BERKELIUM, CALIFORNIUM, EINSTEINIUM, FERMIUM, MANDELEVIUM, NOBELIUM, LAWRENCIUM,
        RUTHERFORDIUM, DUBNIUM, SEABORGIUM, BOHRIUM, HASSIUM, MEITNERIUM, DARMSTADTIUM, ROENTGENIUM, COPERNICUM, NIHONIUM, FLEROVIUM, MOSCOVIUM, LIVERMORIUM, TENNESSINE, OGANESSON
    };

    /**
     * Returns the list of all chemical elements in the periodic table.
     * The order is based on the atomic number.
     * 
     * @param name the name or symbol of the chemical element to search for
     *            (can be in different languages or the symbol)
     * @return an array of ChemicalElement objects representing all known elements
     */
    public static ChemicalElement getElement(String name) {
        for (ChemicalElement chemicalElement : LIST_OF_ELEMENTS) {
            if (name.equals(chemicalElement.getNames().get("de"))) { return chemicalElement; }
            if (name.equals(chemicalElement.getNames().get("en"))) { return chemicalElement; }
            if (name.equals(chemicalElement.getNames().get("fr"))) { return chemicalElement; }
            if (name.equals(chemicalElement.getNames().get("zh"))) { return chemicalElement; }
            if (name.equals(chemicalElement.getNames().get("ru"))) { return chemicalElement; }
            if (name.equals(chemicalElement.getNames().get("jp"))) { return chemicalElement; }
            if (name.equals(chemicalElement.getSymbol())) { return chemicalElement; }
        }
        
        return null;
    }

}