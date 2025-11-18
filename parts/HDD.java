package parts;

public class HDD extends Product
    {
        private String author;

        public HDD(String partName, double price, int amount, String author)
            {
                super(partName, price, amount);
                this.author = author;
            }

        @Override
        public void printInfo ()
            {
                StringBuilder sb = new StringBuilder();
                sb.append("Part Name: ").append(getPartName())
                .append("\nAuthor: ").append(this.author)
                .append("\nPrice: ").append(getPrice());
            }
    }