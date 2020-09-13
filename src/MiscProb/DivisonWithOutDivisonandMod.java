package MiscProb;

public class DivisonWithOutDivisonandMod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		divisonWithShift(30, 5);

	}

	public static void divisonWithShift(int dividend, int divisor) {
		int flag = -1;
		if ((dividend >= 0) == (divisor >= 0)) {
			flag = 1;
		}

		int a = Math.abs(dividend);
		int b = Math.abs(divisor);
		int result = 0;

		while (a - b >= 0) {
			int x = 0;
			while (a - (b << 1 << x) >= 0) {
				x++;
			}
			result += 1 << x;
			a -= b << x;
		}

		System.out.println(result * flag);
		System.out.println(a);
	}

	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1, j = b.length() - 1, carry = 0;
		while (i >= 0 || j >= 0) {
			int sum = carry;
			if (j >= 0)
				sum += b.charAt(j--) - '0';
			if (i >= 0)
				sum += a.charAt(i--) - '0';
			sb.append(sum % 2);
			carry = sum / 2;
		}
		if (carry != 0)
			sb.append(carry);
		return sb.reverse().toString();
	}

}
