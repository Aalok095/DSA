class Bank {
    private long[] bal;
    private int n;
    public Bank(long[] bal) {
        this.bal = bal;
        this.n = bal.length;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if (account1 > n || account2 > n || bal[account1-1] < money) return false;
        else {
        bal[account1-1] -= money;
        bal[account2-1] += money;
        return true;
        }
    }
    
    public boolean deposit(int account, long money) {
        if (account > n) return false;
        else {
            bal[account-1] += money;
            return true;
        }
    }
    
    public boolean withdraw(int account, long money) {
        if (account > n || bal[account-1] < money) return false;
        else {
            bal[account-1] -= money;
            return true;
        }
    }
}


/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */