package com.dipanjal.breadit;

import java.util.List;

/**
 * @author dipanjal
 * @since 5/25/2021
 */

public class CreditResponse {
    private String responseCode;
    private List<Credit> credit;

    public CreditResponse(String responseCode, List<Credit> credit) {
        this.responseCode = responseCode;
        this.credit = credit;
    }

    private static class Credit {
        private String contractNumber;
        private Account account;

        public Credit(String contractNumber, Account account) {
            this.contractNumber = contractNumber;
            this.account = account;
        }
    }

    private enum Type {
        NORMAL, VIP;
    }

    private static class Account {
        private String number;
        private Type type;

        public Account(String number, Type type) {
            this.number = number;
            this.type = type;
        }
    }

    public static void main(String[] args) {
        List<Credit> creditList = List.of(
                new Credit("10001", new Account("387524581", Type.VIP)),
                new Credit("10002", new Account("232003686", Type.NORMAL))
        );
        CreditResponse response = new CreditResponse("OK", creditList);

        System.out.println(50 + 30 + "Java-BredIT");
        System.out.println("Java-BredIT " + 50 + 30);

    }
}
