package com.omnia.pie.cm.web.util;

import java.util.HashMap;
import java.util.Map;

public enum Currency {

	AED("AED", 0, "AED", 784, "Ã˜Â¯.Ã˜Â¥", 2, "United Arab Emirates dirham"), 
	AFN("AFN", 1, "AFN", 971, "Afs", 2, "Afghani"), 
	ALL("ALL", 2, "ALL", 8, "Lek", 2, "Lek"), 
	AMD("AMD", 3, "AMD", 51, "", 0, "Armenian dram"), 
	ANG("ANG", 4, "ANG", 532, "Ã†â€™", 2, "Netherlands Antillean guilder"), 
	AOA("AOA", 5, "AOA", 973, "", 1, "Kwanza"), 
	ARS("ARS", 6, "ARS", 32, "$", 2, "Argentine peso"), 
	AUD("AUD", 7, "AUD", 36, "$", 2, "Australian dollar"), 
	AWG("AWG", 8, "AWG", 533, "Ã†â€™", 2, "Aruban guilder"), 
	AZN("AZN", 9, "AZN", 944, "Ã�Â¼Ã�Â°Ã�Â½", 2, "Azerbaijanian manat"), 
	BAM("BAM", 10, "BAM", 977, "KM", 2, "Convertible marks"), 
	BBD("BBD", 11, "BBD", 52, "$", 2, "Barbados dollar"), 
	BDT("BDT", 12, "BDT", 50, "Ã Â§Â³", 2, "Bangladeshi taka"), 
	BGN("BGN", 13, "BGN", 975, "Ã�Â»Ã�Â²", 2, "Bulgarian lev"), 
	BHD("BHD", 14, "BHD", 48, "BD", 3, "Bahraini dinar"), 
	BIF("BIF", 15, "BIF", 108, "FBu", 0, "Burundian franc"), 
	BMD("BMD", 16, "BMD", 60, "$", 2, "Bermudian dollar"), 
	BND("BND", 17, "BND", 96, "$", 2, "Brunei dollar"), 
	BOB("BOB", 18, "BOB", 68, "$b", 2, "Boliviano"), 
	BOV("BOV", 19, "BOV", 984, "", 2, "Bolivian Mvdol (funds code)"), 
	BRL("BRL", 20, "BRL", 986, "R$", 2, "Brazilian real"), 
	BSD("BSD", 21, "BSD", 44, "$", 2, "Bahamian dollar"), 
	BTN("BTN", 22, "BTN", 64, "", 2, "Ngultrum"), 
	BWP("BWP", 23, "BWP", 72, "", 2, "Pula"), 
	BYR("BYR", 24, "BYR", 974, "p.", 0, "Belarusian ruble"), 
	BZD("BZD", 25, "BZD", 84, "BZ$", 2, "Belize dollar"), 
	CAD("CAD", 26, "CAD", 124, "$", 2, "Canadian dollar"), 
	CDF("CDF", 27, "CDF", 976, "", 2, "Franc Congolais"), 
	CHF("CHF", 28, "CHF", 756, "CHF", 2, "Swiss franc"), 
	CLP("CLP", 29, "CLP", 152, "$", 0, "Chilean peso"), 
	CNY("CNY", 30, "CNY", 156, "Ã‚Â¥", 1, "Chinese Yuan"), 
	COP("COP", 31, "COP", 170, "$", 0, "Colombian peso"), 
	COU("COU", 32, "COU", 970, "", 2, "Unidad de Valor Real"), 
	CRC("CRC", 33, "CRC", 188, "Ã¢â€šÂ¡", 2, "Costa Rican colon"), 
	CUC("CUC", 34, "CUC", 931, "$MN", 2, "Cuban convertible peso"), 
	CUP("CUP", 35, "CUP", 192, "Ã¢â€šÂ±", 2, "Cuban peso"), 
	CVE("CVE", 36, "CVE", 132, "", 2, "Cape Verde escudo"), 
	CZK("CZK", 37, "CZK", 203, "KÃ„ï¿½", 2, "Czech Koruna"), 
	DJF("DJF", 38, "DJF", 262, "", 0, "Djibouti franc"), 
	DKK("DKK", 39, "DKK", 208, "kr", 2, "Danish krone"), 
	DOP("DOP", 40, "DOP", 214, "RD$", 2, "Dominican peso"), 
	DZD("DZD", 41, "DZD", 12, "", 2, "Algerian dinar"), 
	EGP( "EGP", 42, "EGP", 818, "Ã‚Â£", 2, "Egyptian pound"), 
	ERN("ERN", 43, "ERN", 232, "", 2, "Nakfa"), 
	ETB("ETB", 44, "ETB", 230, "", 2, "Ethiopian birr"),
	EUR("EUR", 45, "EUR", 978, "Ã¢â€šÂ¬", 2, "euro"), 
	FJD("FJD", 46, "FJD", 242, "$", 2, "Fiji dollar"), 
	FKP("FKP", 47, "FKP", 238, "Ã‚Â£", 2, "Falkland Islands pound"), 
	GBP("GBP", 48, "GBP", 826, "Ã‚Â£", 2, "Pound sterling"), 
	GEL("GEL", 49, "GEL", 981, "", 2, "Lari"), 
	GHS("GHS", 50, "GHS", 936, "", 2, "Cedi"), 
	GIP("GIP", 51, "GIP", 292, "Ã‚Â£", 2, "Gibraltar pound"), 
	GMD("GMD", 52, "GMD", 270, "", 2, "Dalasi"), 
	GNF("GNF", 53, "GNF", 324, "", 0, "Guinea franc"), 
	GTQ("GTQ", 54, "GTQ", 320, "Q", 2, "Quetzal"), 
	GYD("GYD", 55, "GYD", 328, "$", 2, "Guyana dollar"), 
	HKD("HKD", 56, "HKD", 344, "$", 2, "Hong Kong dollar"), 
	HNL("HNL", 57, "HNL", 340, "L", 2, "Lempira"), 
	HRK("HRK", 58, "HRK", 191, "kn", 2, "Croatian kuna"), 
	HTG("HTG", 59, "HTG", 332, "", 2, "Haiti gourde"),
	HUF("HUF", 60, "HUF", 348, "Ft", 2, "Forint"),
	IDR("IDR", 61, "IDR", 360, "Rp", 0, "Rupiah"),
	ILS("ILS", 62, "ILS", 376, "Ã¢â€šÂª", 2, "Israeli new sheqel"),
	INR("INR", 63, "INR", 356, "Ã¢â€šÂ¹", 2, "Indian rupee"),
	IQD("IQD", 64, "IQD", 368, "", 0,"Iraqi dinar"),
	IRR("IRR", 65, "IRR", 364, "Ã¯Â·Â¼", 0, "Iranian rial"),
	ISK("ISK", 66, "ISK", 352, "kr", 0, "Iceland krona"),
	JMD("JMD", 67, "JMD",388, "J$", 2, "Jamaican dollar"),
	JOD("JOD", 68, "JOD", 400, "", 3, "Jordanian dinar"),
	JPY("JPY", 69, "JPY", 392, "Ã‚Â¥", 0, "Japanese yen"),
	KES("KES", 70, "KES", 404, "", 2, "Kenyan shilling"),
	KGS("KGS", 71, "KGS", 417, "Ã�Â»Ã�Â²", 2, "Som"),
	KHR("KHR", 72, "KHR", 116, "Ã¡Å¸â€º", 0, "Riel"),
	KMF("KMF", 73, "KMF", 174, "", 0, "Comoro franc"),
	KPW("KPW", 74, "KPW", 408, "Ã¢â€šÂ©", 0, "North Korean won"),
	KRW("KRW", 75, "KRW", 410, "Ã¢â€šÂ©", 0,"South Korean won"),
	KWD("KWD", 76, "KWD", 414, "", 3, "Kuwaiti dinar"),
	KYD("KYD", 77, "KYD", 136, "$", 2, "Cayman Islands dollar"),
	KZT("KZT",78, "KZT", 398, "Ã�Â»Ã�Â²", 2, "Tenge"),
	LAK("LAK", 79, "LAK", 418, "Ã¢â€šÂ­", 0, "Kip"),
	LBP("LBP", 80, "LBP", 422, "Ã‚Â£", 0, "Lebanese pound"),
	LKR("LKR",81, "LKR", 144, "Ã¢â€šÂ¨", 2, "Sri Lanka rupee"),
	LRD("LRD", 82, "LRD", 430, "$", 2, "Liberian dollar"),
	LSL("LSL", 83, "LSL", 426, "", 2,"Lesotho loti"),
	LTL("LTL", 84, "LTL", 440, "Lt", 2, "Lithuanian litas"),
	LYD("LYD", 85, "LYD", 434, "", 3, "Libyan dinar"),
	MAD("MAD", 86, "MAD",504, "", 2, "Moroccan dirham"),
	MDL("MDL", 87, "MDL", 498, "", 2, "Moldovan leu"),
	MGA("MGA", 88, "MGA", 969, "Ar", 2, "Malagasy ariary"),
	MKD("MKD", 89, "MKD", 807, "Ã�Â´Ã�ÂµÃ�Â½", 2, "Denar"),
	MMK("MMK", 90, "MMK", 104, "", 0, "Kyat"),
	MNT("MNT", 91, "MNT", 496, "Ã¢â€šÂ®", 2, "Tughrik"),
	MOP("MOP", 92, "MOP", 446, "", 1, "Pataca"),
	MRO("MRO", 93, "MRO", 478, "UM", 2, "Mauritanian ouguiya"),
	MUR("MUR", 94, "MUR", 480, "Ã¢â€šÂ¨", 2,"Mauritius rupee"),
	MVR("MVR", 95, "MVR", 462, "", 2, "Rufiyaa"),
	MWK("MWK", 96, "MWK", 454, "", 2, "Kwacha"),
	MXN("MXN", 97, "MXN", 484, "$", 2,"Mexican peso"),
	MXV("MXV", 98, "MXV", 979, "", 2, "Mexican Unidad de Inversion"),
	MYR("MYR", 99, "MYR", 458, "RM", 2, "Malaysian ringgit"),
	MZN("MZN", 100, "MZN", 943, "MT", 2, "Metical"),
	NAD("NAD", 101, "NAD", 516, "$", 2, "Namibian dollar"),
	NGN("NGN", 102, "NGN", 566, "Ã¢â€šÂ¦", 2, "Naira"),
	NIO("NIO", 103, "NIO", 558, "C$", 2, "Cordoba oro"),
	NOK("NOK", 104, "NOK", 578, "kr", 2, "Norwegian krone"),
	NPR("NPR", 105, "NPR", 524, "Ã¢â€šÂ¨", 2,"Nepalese rupee"),
	NZD("NZD", 106, "NZD", 554, "$", 2, "New Zealand dollar"),
	OMR("OMR", 107, "OMR", 512, "Ã¯Â·Â¼", 3, "Rial Omani"),
	PAB("PAB", 108,"PAB", 590, "B/.", 2, "Balboa"),
	PEN("PEN", 109, "PEN", 604, "S/.", 2, "Nuevo sol"),
	PGK("PGK", 110, "PGK", 598, "", 2, "Kina"),
	PHP("PHP", 111,"PHP", 608, "Ã¢â€šÂ±", 2, "Philippine peso"),
	PKR("PKR", 112, "PKR", 586, "Ã¢â€šÂ¨", 2, "Pakistan rupee"),
	PLN("PLN", 113, "PLN", 985, "zÃ…â€š", 2, "Z?oty"),
	PYG("PYG", 114, "PYG", 600, "Gs", 0, "Guarani"),
	QAR("QAR", 115, "QAR", 634, "Ã¯Â·Â¼", 2, "Qatari rial"),
	RON("RON", 116, "RON", 946, "lei", 2,"Romanian new leu"),
	RSD("RSD", 117, "RSD", 941, "Ã�â€�Ã�Â¸Ã�Â½.", 2, "Serbian dinar"),
	RUB("RUB", 118, "RUB", 643, "Ã‘â‚¬Ã‘Æ’Ã�Â±", 2, "Russian rouble"),
	RWF("RWF", 119, "RWF", 646, "", 0, "Rwanda franc"),
	SAR("SAR", 120, "SAR", 682, "Ã¯Â·Â¼", 2, "Saudi riyal"),
	SBD("SBD", 121, "SBD", 90, "$", 2,"Solomon Islands dollar"),
	SCR("SCR", 122, "SCR", 690, "Ã¢â€šÂ¨", 2, "Seychelles rupee"),
	SDG("SDG", 123, "SDG", 938, "", 2, "Sudanese pound"),
	SEK("SEK", 124, "SEK", 752, "kr", 2, "Swedish krona/kronor"),
	SGD("SGD", 125, "SGD", 702, "$", 2, "Singapore dollar"),
	SHP("SHP", 126, "SHP", 654,"Ã‚Â£", 2, "Saint Helena pound"),
	SLL("SLL", 127, "SLL", 694, "", 0, "Leone"),
	SOS("SOS", 128, "SOS", 706, "S", 2, "Somali shilling"),
	SRD("SRD",129, "SRD", 968, "$", 2, "Surinam dollar"),
	SSP("SSP", 130, "SSP", 728, "Ã‚Â£", 2, "South Sudanese pound"),
	STD("STD", 131, "STD", 678, "Db", 0,"Dobra"),
	SYP("SYP", 132, "SYP", 760, "Ã‚Â£", 2, "Syrian pound"),
	SZL("SZL", 133, "SZL", 748, "", 2, "Lilangeni"),
	THB("THB", 134, "THB", 764, "Ã Â¸Â¿",2, "Baht"),
	TJS("TJS", 135, "TJS", 972, "", 2, "Somoni"),
	TMT("TMT", 136, "TMT", 934, "", 2, "Manat"),
	TND("TND", 137, "TND", 788, "", 3,"Tunisian dinar"),
	TOP("TOP", 138, "TOP", 776, "T$", 2, "Pa\'anga"),
	TRY("TRY", 139, "TRY", 949, "", 2, "Turkish lira"),
	TTD("TTD", 140, "TTD",780, "TT$", 2, "Trinidad and Tobago dollar"),
	TWD("TWD", 141, "TWD", 901, "NT$", 1, "New Taiwan dollar"),
	TZS("TZS", 142, "TZS", 834, "", 2,"Tanzanian shilling"),
	UAH("UAH", 143, "UAH", 980, "Ã¢â€šÂ´", 2, "Hryvnia"),
	UGX("UGX", 144, "UGX", 800, "USh", 0, "Uganda shilling"),
	USD("USD", 145,"USD", 840, "$", 2, "US dollar"),
	UZS("UZS", 146, "UZS", 860, "Ã�Â»Ã�Â²", 2, "Uzbekistan som"),
	VEF("VEF", 147, "VEF", 937, "Bs", 2,"Venezuelan bolivar fuerte"),
	VND("VND", 148, "VND", 704, "Ã¢â€šÂ«", 0, "Vietnamese Dong"),
	VUV("VUV", 149, "VUV", 548, "", 0, "Vatu"),
	WST("WST", 150,"WST", 882, "", 2, "Samoan tala"),
	XAF("XAF", 151, "XAF", 950, "FCFA", 0, "CFA franc BEAC"),
	XCD("XCD", 152, "XCD", 951, "$", 2,"East Caribbean dollar"),
	XOF("XOF", 153, "XOF", 952, "CFA", 0, "CFA Franc BCEAO"),
	XPF("XPF", 154, "XPF", 953, "F", 0, "CFP franc"),
	YER("YER",155, "YER", 886, "Ã¯Â·Â¼", 0, "Yemeni rial"),
	ZAR("ZAR", 156, "ZAR", 710, "R", 2, "South African rand"),
	ZMW("ZMW", 157, "ZMW", 967, "ZK", 2, "Kwacha"),
	ZWL("ZWL", 158, "ZWL", 932, "Z$", 2, "Zimbabwe dollar"),
	Unknown("Unknown", 159, "", 0, "", 0, "");

	private static final Map<Integer, Currency> IntToCurrencyMap = new HashMap<Integer, Currency> ();
	private final String alpha;
	private final int code;
	private final String symbol;
	private final int fractionDigits;
	private final String name;

	private static final Currency[] values = new Currency[] { AED, AFN, ALL, AMD, ANG, AOA, ARS, AUD, AWG, AZN, BAM, BBD, BDT, BGN, BHD, BIF, BMD, BND, BOB,
			BOV, BRL, BSD, BTN, BWP, BYR, BZD, CAD, CDF, CHF, CLP, CNY, COP, COU, CRC, CUC, CUP, CVE, CZK, DJF, DKK, DOP, DZD, EGP, ERN, ETB, EUR, FJD, FKP,
			GBP, GEL, GHS, GIP, GMD, GNF, GTQ, GYD, HKD, HNL, HRK, HTG, HUF, IDR, ILS, INR, IQD, IRR, ISK, JMD, JOD, JPY, KES, KGS, KHR, KMF, KPW, KRW, KWD,
			KYD, KZT, LAK, LBP, LKR, LRD, LSL, LTL, LYD, MAD, MDL, MGA, MKD, MMK, MNT, MOP, MRO, MUR, MVR, MWK, MXN, MXV, MYR, MZN, NAD, NGN, NIO, NOK, NPR,
			NZD, OMR, PAB, PEN, PGK, PHP, PKR, PLN, PYG, QAR, RON, RSD, RUB, RWF, SAR, SBD, SCR, SDG, SEK, SGD, SHP, SLL, SOS, SRD, SSP, STD, SYP, SZL, THB,
			TJS, TMT, TND, TOP, TRY, TTD, TWD, TZS, UAH, UGX, USD, UZS, VEF, VND, VUV, WST, XAF, XCD, XOF, XPF, YER, ZAR, ZMW, ZWL, Unknown };

	private Currency(String var1, int var2, String alpha, int code, String symbol, int fractionDigits, String name) {
		this.alpha = alpha;
		this.code = code;
		this.symbol = symbol;
		this.fractionDigits = fractionDigits;
		this.name = name;
	}

	public static Currency getCurrency(int code) {
		Currency currency = (Currency) IntToCurrencyMap.get(Integer.valueOf(code));
		return currency == null ? Unknown : currency;
	}

	public final int getCode() {
		return this.code;
	}

	public final String getSymbol() {
		return this.symbol;
	}

	public final int getFractionDigits() {
		return this.fractionDigits;
	}

	public final String getAlpha() {
		return this.alpha;
	}

	public final String getName() {
		return this.name;
	}

	public String getSendableCurrencyCode() {
		return String.format("%04d", new Object[] { Integer.valueOf(this.code) });
	}

	static {
		Currency[] arr = values;
		int len = arr.length;

		for (int i = 0; i < len; ++i) {
			Currency currency = arr[i];
			IntToCurrencyMap.put(Integer.valueOf(currency.code), currency);
		}

	}
}
