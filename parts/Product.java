package parts;

public abstract class Product
    {
        protected String partName;
        protected double price;
        protected int amount;
        final float tax = 0.12f;

        public Product (String partName, double price, int amount)
            {
                this.partName = partName;
                this.price = price;
                this.amount = amount;
            }        

        public String getPartName (){return partName;}
        public double getPrice (){return price;}
        public int getAmount (){return amount;}

        public abstract void printInfo ();
    }