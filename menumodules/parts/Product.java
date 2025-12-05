package menumodules.parts;

public abstract class Product
    {
        //Setting Attributes
        protected String partName;
        protected double price;
        protected int amount;
        final float tax = 0.12f;

        //Constructor
        public Product (String partName, double price, int amount)
            {
                this.partName = partName;
                this.price = price;
                this.amount = amount;
            }        

        //Getters
        public String getPartName (){return partName;}
        public double getPrice (){return price;}
        public int getAmount (){return amount;}
        public float getTax() { return tax; }
        //Setters
        public void setAmount(int amount) { this.amount = amount; }

        //To get the brand name on other java files
        public abstract String getBrand();
        public abstract void printInfo();
    }