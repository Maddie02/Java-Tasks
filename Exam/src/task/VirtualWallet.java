package task;

import java.util.ArrayList;

public class VirtualWallet implements IVirtualWallet {
    ArrayList<Card> wallet = new ArrayList<>();

    @Override
    public boolean registerCard(Card card) {
        for (Card cards : getWallet()) {
            if (cards.getName().equals(card.getName())) {
                return false;
            }
        }
        wallet.add(card);
        return true;
    }

    @Override
    public boolean unregisterCard(Card card) {
        for (Card cards : getWallet()) {
            if (cards.getName().equals(card.getName())) {
                wallet.remove(card);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean executePayment(Card card, PaymentInfo paymentInfo) {
        if (paymentInfo.getCost() > card.getAmount()) {
            return false;
        }

        card.executePayment(paymentInfo.getCost());
        return true;
    }

    @Override
    public boolean feed(Card card, double amount) {
        if (amount < 0) {
            return false;
        }
        card.setAmount(card.getAmount() + amount);
        return true;
    }

    @Override
    public Card getCardByName(String name) {
        for (Card cards : getWallet()) {
            if (cards.getName().equals(name)) {
                return cards;
            }
        }

        return null;
    }

    @Override
    public int getTotalNumberOfCards() {
        return getWallet().size();
    }

    @Override
    public ArrayList<Card> sortCardsByName() {
        return null;
    }

    @Override
    public ArrayList<Card> sortCardsByAmount() {
        getWallet().sort(new AmountComparator());
        return getWallet();
    }

    public ArrayList<Card> getWallet() {
        return wallet;
    }
}
