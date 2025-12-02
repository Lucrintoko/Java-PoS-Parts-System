package menumodules;

import java.util.ArrayList;
import java.util.List;
import menumodules.parts.*;

public class ProductStorage 
{
    private List<CPU> CPUs;
    private List<GPU> GPUs;
    private List<SSD> SSDs;
    private List<RAM> RAMs;

    public ProductStorage ()
        {
            CPUs = new ArrayList<>();
            GPUs = new ArrayList<>();
            SSDs = new ArrayList<>();
            RAMs = new ArrayList<>();

            //CPUs List
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
            CPUs.add(new CPU("Ryzen 5 5600G", 
                22522.10, 15, 
                    "AMD"));
            CPUs.add(new CPU("Ryzen 5 8600G", 
                17231.29, 3, 
                    "AMD"));

            //GPUs
            GPUs.add(new GPU("GeForce RTX 5090",
                188915.44, 3,
                    "NVIDIA"));
            GPUs.add(new GPU("GeForce RTX 5070ti",
                57491.96, 5,
                    "NVIDIA"));
            GPUs.add(new GPU("Radeon RX 9070 XT",
                44676.79, 7,
                    "AMD"));
            GPUs.add(new GPU("Radeon RX 9070",
                39464, 4,
                    "AMD"));
            GPUs.add(new GPU("GeForce RTX 5060ti",
                31997, 9,
                    "NVIDIA"));
            GPUs.add(new GPU("Arc B570",
                14245, 4,
                    "Intel"));
            GPUs.add(new GPU("Radeon RX 9060 XT",
                35655.19, 7,
                    "AMD"));
            GPUs.add(new GPU("GeForce RTX 5060",
                20941.75, 4,
                    "NVIDIA"));

            //HDDs
            SSDs.add(new SSD("Samsung 990 Pro", 
                12687.35, 6, 
                    "Samsung"));
            SSDs.add(new SSD("Sandisk WD Black SN8100", 
                17945.75, 3, 
                    "Sandisk"));
            SSDs.add(new SSD("Sandisk WD Black SN7100", 
                13427.67, 6, 
                    "Sandisk"));
            SSDs.add(new SSD("Crucial P3", 
                9071.85, 10, 
                    "Crucial"));
            SSDs.add(new SSD("Sandisk WD Black SN850X 4TB", 
                24668.62, 4, 
                    "Sandisk"));
            SSDs.add(new SSD("Corsair MP600 Mini E27T", 
                7772.79, 9, 
                    "Corsair"));
            SSDs.add(new SSD("TeamGroup MP44Q", 
                6855.19, 8, 
                    "TeamGroup"));
            
            //RAMs
            RAMs.add(new RAM("G.Skill Trident Z5 Neo RGB DDR5-6000 (4 x 64GB", 
                171956.95, 4, 
                    "G.Skill"));
            RAMs.add(new RAM("Corsair Vengeance DDR5-5200 (2 x 32GB)", 
                56521.91, 6, 
                    "Corsair"));
            RAMs.add(new RAM("TeamGroup T-Force Xtreem DDR4-3600 (2 x 8GB)", 
                8631.47, 5, 
                    "TeamGroup"));
            RAMs.add(new RAM("Patriot Viper Venom DDR5-6400 (2 x 24GB)", 
                19396.15, 7, 
                    "Patriot Memory"));
            RAMs.add(new RAM("Corsair Vengeance RGB Pro DDR4-32000 (2 x 16GB)", 
                13831.99, 9, 
                    "Corsair"));
            RAMs.add(new RAM("Team XTREEM ARGB DDR5-8200 (2 x 24GB)", 
                37393.43, 10, 
                    "TeamGroup"));
        }
}
