public abstract class Product
    {
        private String partName;
        private float price;
        final float tax = 0.12f;

        public Product (String partName, int price)
            {
                this.partName = partName;
                this.price = price;
            }        

        public String getPartName (){return partName;}
        public float getPrice (){return price;}

        public abstract void printInfo ();
    }

class CPU extends Product
    {
        private String author;

        public CPU(String partName, int price, String author)
            {
                super(partName, price);
                this.author = author;
            }

        @Override
        public void printInfo ()
            {
                StringBuilder sb = new StringBuilder();
                sb.append("b");
            }
    }