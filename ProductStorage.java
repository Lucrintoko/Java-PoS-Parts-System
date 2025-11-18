import java.util.ArrayList;
import java.util.List;
import parts.*;

public class ProductStorage 
{
    private List<CPU> CPUs;
    private List<GPU> GPUs;
    private List<HDD> HDDs;
    private List<RAM> RAMs;

    public ProductStorage ()
        {
            CPUs = new ArrayList<>();
            GPUs = new ArrayList<>();
            HDDs = new ArrayList<>();
            RAMs = new ArrayList<>();

            CPUs.add(new CPU("Ryzen 7 980X3D", 
                35813.11, 10, 
                    "AMD"));
            CPUs.add(new CPU("Ryzen 5 9600X", 
                16022.71, 8, 
                    "AMD"));
            CPUs.add(new CPU("Ryzen 9 9950X3D", 
                52310.71, 15, 
                    "AMD"));
            CPUs.add(new CPU("Core i5-12400", 
                16996.72, 4, 
                    "Intel"));
            CPUs.add(new CPU("Ryzen 5 8600G", 
                16538.98, 20, 
                    "AMD"));
            CPUs.add(new CPU("Ryzen 7 9700X", 
                24622.07, 10, 
                    "AMD"));
            CPUs.add(new CPU("Core i9-14900K", 
                34900.31, 3, 
                    "Intel"));
            CPUs.add(new CPU("Ryzen 5 5600", 
                14225.15, 6, 
                    "AMD"));
        }
}
