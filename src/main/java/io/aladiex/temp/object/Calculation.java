package io.aladiex.temp.object;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculation {
	
	public String toFixed(String input, int dec) {
		BigDecimal biga = new BigDecimal(input);
		biga = biga.setScale(dec, RoundingMode.HALF_UP);
		return biga.toString();
	};
	
	
	public boolean isIntegerValue(String a) {
		BigDecimal biga = new BigDecimal(a);
		return biga.stripTrailingZeros().scale() <= 0;
	}

	// ==================================================
	// BigDecimal && BigDecimal

	public boolean isBigger(BigDecimal a, BigDecimal b) {
		a = a.setScale(8, RoundingMode.HALF_UP);
		b = b.setScale(8, RoundingMode.HALF_UP);
		if (a.compareTo(b) == 1)
			return true;
		else
			return false;
	}

	public boolean isEqual(BigDecimal a, BigDecimal b) {
		a = a.setScale(8, RoundingMode.HALF_UP);
		b = b.setScale(8, RoundingMode.HALF_UP);
		if (a.compareTo(b) == 0)
			return true;
		else
			return false;
	}

	public boolean isSmaller(BigDecimal a, BigDecimal b) {
		a = a.setScale(8, RoundingMode.HALF_UP);
		b = b.setScale(8, RoundingMode.HALF_UP);
		if (a.compareTo(b) == -1)
			return true;
		else
			return false;
	}

	// ====================================================
	// String && String
	public boolean isSmaller(String a, String b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.setScale(8, RoundingMode.HALF_UP);
		bigb = bigb.setScale(8, RoundingMode.HALF_UP);
		if (biga.compareTo(bigb) == -1)
			return true;
		else
			return false;
	}

	public boolean isBigger(String a, String b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.setScale(8, RoundingMode.HALF_UP);
		bigb = bigb.setScale(8, RoundingMode.HALF_UP);
		if (biga.compareTo(bigb) == 1)
			return true;
		else
			return false;
	}

	public boolean isEqual(String a, String b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.setScale(8, RoundingMode.HALF_UP);
		bigb = bigb.setScale(8, RoundingMode.HALF_UP);
		if (biga.compareTo(bigb) == 0)
			return true;
		else
			return false;
	}

	// ====================================================
	// String && Double
	public boolean isSmaller(String a, Double b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.setScale(8, RoundingMode.HALF_UP);
		bigb = bigb.setScale(8, RoundingMode.HALF_UP);
		if (biga.compareTo(bigb) == -1)
			return true;
		else
			return false;
	}

	public boolean isBigger(String a, Double b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.setScale(8, RoundingMode.HALF_UP);
		bigb = bigb.setScale(8, RoundingMode.HALF_UP);
		if (biga.compareTo(bigb) == 1)
			return true;
		else
			return false;
	}

	public boolean isEqual(String a, Double b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.setScale(8, RoundingMode.HALF_UP);
		bigb = bigb.setScale(8, RoundingMode.HALF_UP);
		if (biga.compareTo(bigb) == 0)
			return true;
		else
			return false;
	}

	// ====================================================
	// String && Double
	public boolean isSmaller(String a, Long b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.setScale(8, RoundingMode.HALF_UP);
		bigb = bigb.setScale(8, RoundingMode.HALF_UP);
		if (biga.compareTo(bigb) == -1)
			return true;
		else
			return false;
	}

	public boolean isBigger(String a, Long b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.setScale(8, RoundingMode.HALF_UP);
		bigb = bigb.setScale(8, RoundingMode.HALF_UP);
		if (biga.compareTo(bigb) == 1)
			return true;
		else
			return false;
	}

	public boolean isEqual(String a, Long b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.setScale(8, RoundingMode.HALF_UP);
		bigb = bigb.setScale(8, RoundingMode.HALF_UP);
		if (biga.compareTo(bigb) == 0)
			return true;
		else
			return false;
	}

	// ===========================================
	// BigDecimal && String

	public boolean isSmaller(BigDecimal a, String b) {
		BigDecimal bigb = new BigDecimal(b);
		bigb = bigb.setScale(8, RoundingMode.HALF_UP);
		if (a.compareTo(bigb) == -1)
			return true;
		else
			return false;
	}

	public boolean isBigger(BigDecimal a, String b) {
		BigDecimal bigb = new BigDecimal(b);
		bigb = bigb.setScale(8, RoundingMode.HALF_UP);
		if (a.compareTo(bigb) == 1)
			return true;
		else
			return false;
	}

	public boolean isEqual(BigDecimal a, String b) {
		BigDecimal bigb = new BigDecimal(b);
		bigb = bigb.setScale(8, RoundingMode.HALF_UP);
		if (a.compareTo(bigb) == 0)
			return true;
		else
			return false;
	}

	// =============================================
	// BigDecimal && Double
	public boolean isSmaller(BigDecimal a, Double b) {
		BigDecimal bigb = new BigDecimal(b);
		bigb = bigb.setScale(8, RoundingMode.HALF_UP);
		if (a.compareTo(bigb) == -1)
			return true;
		else
			return false;
	}

	public boolean isBigger(BigDecimal a, Double b) {
		BigDecimal bigb = new BigDecimal(b);
		bigb = bigb.setScale(8, RoundingMode.HALF_UP);
		if (a.compareTo(bigb) == 1)
			return true;
		else
			return false;
	}

	public boolean isEqual(BigDecimal a, Double b) {
		BigDecimal bigb = new BigDecimal(b);
		bigb = bigb.setScale(8, RoundingMode.HALF_UP);
		if (a.compareTo(bigb) == 0)
			return true;
		else
			return false;
	}

	// =============================================
	// BigDecimal && Double
	public boolean isSmaller(BigDecimal a, Long b) {
		BigDecimal bigb = new BigDecimal(b);
		bigb = bigb.setScale(8, RoundingMode.HALF_UP);
		if (a.compareTo(bigb) == -1)
			return true;
		else
			return false;
	}

	public boolean isBigger(BigDecimal a, Long b) {
		BigDecimal bigb = new BigDecimal(b);
		bigb = bigb.setScale(8, RoundingMode.HALF_UP);
		if (a.compareTo(bigb) == 1)
			return true;
		else
			return false;
	}

	public boolean isEqual(BigDecimal a, Long b) {
		BigDecimal bigb = new BigDecimal(b);
		bigb = bigb.setScale(8, RoundingMode.HALF_UP);
		if (a.compareTo(bigb) == 0)
			return true;
		else
			return false;
	}

	// =============================================
	// BigDecimal && Integer
	public boolean isSmaller(BigDecimal a, int b) {
		BigDecimal bigb = new BigDecimal(b);
		bigb = bigb.setScale(8, RoundingMode.HALF_UP);
		if (a.compareTo(bigb) == -1)
			return true;
		else
			return false;
	}

	public boolean isBigger(BigDecimal a, int b) {
		BigDecimal bigb = new BigDecimal(b);
		bigb = bigb.setScale(8, RoundingMode.HALF_UP);
		if (a.compareTo(bigb) == 1)
			return true;
		else
			return false;
	}

	public boolean isEqual(BigDecimal a, int b) {
		BigDecimal bigb = new BigDecimal(b);
		bigb = bigb.setScale(8, RoundingMode.HALF_UP);
		if (a.compareTo(bigb) == 0)
			return true;
		else
			return false;
	}
	// =========================================================

	// string a, string b
	public String sub(String a, String b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.subtract(bigb);
		biga = biga.setScale(8, RoundingMode.HALF_UP);
		if ("0E-8".equalsIgnoreCase(biga.toString())) {
			return "0.0";
		}
		return biga.toString();
	}

	public String total(String a, String b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.add(bigb);
		biga = biga.setScale(8, RoundingMode.HALF_UP);
		if ("0E-8".equalsIgnoreCase(biga.toString())) {
			return "0.0";
		}
		return biga.toString();
	}

	public String multip(String a, String b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.multiply(bigb);
		biga = biga.setScale(8, RoundingMode.HALF_UP);
		if ("0E-8".equalsIgnoreCase(biga.toString())) {
			return "0.0";
		}
		return biga.toString();
	}

	public String divide(String a, String b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.divide(bigb, 8, RoundingMode.HALF_UP);
		if ("0E-8".equalsIgnoreCase(biga.toString())) {
			return "0.0";
		}
		return biga.toString();
	}
	// =========================================================

	// String a, long b
	public String sub(String a, Long b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.subtract(bigb);
		biga = biga.setScale(8, RoundingMode.HALF_UP);
		if ("0E-8".equalsIgnoreCase(biga.toString())) {
			return "0.0";
		}
		return biga.toString();
	}

	public String total(String a, Long b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.add(bigb);
		biga = biga.setScale(8, RoundingMode.HALF_UP);
		if ("0E-8".equalsIgnoreCase(biga.toString())) {
			return "0.0";
		}
		return biga.toString();
	}

	public String multip(String a, Long b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.multiply(bigb);
		biga = biga.setScale(8, RoundingMode.HALF_UP);
		if ("0E-8".equalsIgnoreCase(biga.toString())) {
			return "0.0";
		}
		return biga.toString();
	}

	public String divide(String a, Long b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.divide(bigb, 8, RoundingMode.HALF_UP);
		if ("0E-8".equalsIgnoreCase(biga.toString())) {
			return "0.0";
		}
		return biga.toString();
	}
	// =========================================================

	// String a, double b
	public String sub(String a, double b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.subtract(bigb);
		biga = biga.setScale(8, RoundingMode.HALF_UP);
		if ("0E-8".equalsIgnoreCase(biga.toString())) {
			return "0.0";
		}
		return biga.toString();
	}

	public String total(String a, double b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.add(bigb);
		biga = biga.setScale(8, RoundingMode.HALF_UP);
		if ("0E-8".equalsIgnoreCase(biga.toString())) {
			return "0.0";
		}
		return biga.toString();
	}

	public String multip(String a, double b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.multiply(bigb);
		biga = biga.setScale(8, RoundingMode.HALF_UP);
		if ("0E-8".equalsIgnoreCase(biga.toString())) {
			return "0.0";
		}
		return biga.toString();
	}

	public String divide(String a, double b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.divide(bigb, 8, RoundingMode.HALF_UP);
		if ("0E-8".equalsIgnoreCase(biga.toString())) {
			return "0.0";
		}
		return biga.toString();
	}
	// =========================================================

	// double a, double b
	public String sub(double a, double b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.subtract(bigb);
		biga = biga.setScale(8, RoundingMode.HALF_UP);
		if ("0E-8".equalsIgnoreCase(biga.toString())) {
			return "0.0";
		}
		return biga.toString();
	}

	public String total(double a, double b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.add(bigb);
		biga = biga.setScale(8, RoundingMode.HALF_UP);
		if ("0E-8".equalsIgnoreCase(biga.toString())) {
			return "0.0";
		}
		return biga.toString();
	}

	public String multip(double a, double b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.multiply(bigb);
		biga = biga.setScale(8, RoundingMode.HALF_UP);
		if ("0E-8".equalsIgnoreCase(biga.toString())) {
			return "0.0";
		}
		return biga.toString();
	}

	public String divide(double a, double b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.divide(bigb, 8, RoundingMode.HALF_UP);
		if ("0E-8".equalsIgnoreCase(biga.toString())) {
			return "0.0";
		}
		return biga.toString();
	}
	// =========================================================

	// string a , int b
	public String sub(String a, int b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.subtract(bigb);
		biga = biga.setScale(8, RoundingMode.HALF_UP);
		if ("0E-8".equalsIgnoreCase(biga.toString())) {
			return "0.0";
		}
		return biga.toString();
	}

	public String total(String a, int b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.add(bigb);
		biga = biga.setScale(8, RoundingMode.HALF_UP);
		if ("0E-8".equalsIgnoreCase(biga.toString())) {
			return "0.0";
		}
		return biga.toString();
	}

	public String multip(String a, int b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.multiply(bigb);
		biga = biga.setScale(8, RoundingMode.HALF_UP);
		if ("0E-8".equalsIgnoreCase(biga.toString())) {
			return "0.0";
		}
		return biga.toString();
	}

	public String divide(String a, int b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.divide(bigb, 8, RoundingMode.HALF_UP);
		if ("0E-8".equalsIgnoreCase(biga.toString())) {
			return "0.0";
		}
		return biga.toString();
	}
	// =========================================================

	// double a, string b
	public String sub(double a, String b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.subtract(bigb);
		biga = biga.setScale(8, RoundingMode.HALF_UP);
		if ("0E-8".equalsIgnoreCase(biga.toString())) {
			return "0.0";
		}
		return biga.toString();
	}

	public String total(double a, String b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.add(bigb);
		biga = biga.setScale(8, RoundingMode.HALF_UP);
		if ("0E-8".equalsIgnoreCase(biga.toString())) {
			return "0.0";
		}
		return biga.toString();
	}

	public String multip(double a, String b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.multiply(bigb);
		biga = biga.setScale(8, RoundingMode.HALF_UP);
		if ("0E-8".equalsIgnoreCase(biga.toString())) {
			return "0.0";
		}
		return biga.toString();
	}

	public String divide(double a, String b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.divide(bigb, 8, RoundingMode.HALF_UP);
		if ("0E-8".equalsIgnoreCase(biga.toString())) {
			return "0.0";
		}
		return biga.toString();
	}
	// =========================================================

	// int a, string b
	public String sub(int a, String b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.subtract(bigb);
		biga = biga.setScale(8, RoundingMode.HALF_UP);
		if ("0E-8".equalsIgnoreCase(biga.toString())) {
			return "0.0";
		}
		return biga.toString();
	}

	public String total(int a, String b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.add(bigb);
		biga = biga.setScale(8, RoundingMode.HALF_UP);
		if ("0E-8".equalsIgnoreCase(biga.toString())) {
			return "0.0";
		}
		return biga.toString();
	}

	public String multip(int a, String b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.multiply(bigb);
		biga = biga.setScale(8, RoundingMode.HALF_UP);
		if ("0E-8".equalsIgnoreCase(biga.toString())) {
			return "0.0";
		}
		return biga.toString();
	}

	public String divide(int a, String b) {
		BigDecimal biga = new BigDecimal(a);
		BigDecimal bigb = new BigDecimal(b);
		biga = biga.divide(bigb, 8, RoundingMode.HALF_UP);
		if ("0E-8".equalsIgnoreCase(biga.toString())) {
			return "0.0";
		}
		return biga.toString();
	}

}
