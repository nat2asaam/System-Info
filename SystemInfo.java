import java.io.File;
import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

class SystemInfo{
	public static String osName(){
		return System.getProperty("os.name");
	}
	public static String osVersion(){
		return System.getProperty("os.version");
	}
	public static String osArch(){
		return System.getProperty("os.arch");
	}
	public static long totalMem() {
        return Runtime.getRuntime().totalMemory();
    }

    public static long usedMem() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public static String diskInfo() {
        /* Get a list of all filesystem roots on this system */
        File[] roots = File.listRoots();
        StringBuilder sb = new StringBuilder();

        /* For each filesystem root, print some info */
        for (File root : roots) {
            sb.append("File system root: ");
            sb.append(root.getAbsolutePath());
            sb.append(", ");
            sb.append("Total space (GB): ");
            sb.append((root.getTotalSpace()/1073741824));
            sb.append(", ");
            sb.append("Free space (GB): ");
            sb.append((root.getFreeSpace()/1073741824));
            sb.append(", ");
            sb.append("Usable space (GB): ");
            sb.append((root.getUsableSpace()/1073741824));
            sb.append(" ");
        }
        return sb.toString();
    }

	public static double getCpuLoad() {
	    OperatingSystemMXBean osBean =(com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
	    return osBean.getProcessCpuLoad();
	}
    public static void main(String args[]){
    	System.out.println("OS Name is :"+osName());
    	System.out.println("OS Version is :"+osVersion());
    	System.out.println("OS Arch is :"+osArch());
    	System.out.println("Total Memory is :"+(totalMem()/1024)+" KB");
    	System.out.println("Used Memory is :"+(usedMem()/1024)+" KB");
    	System.out.println(diskInfo());
    	System.out.println("CPU Load: "+getCpuLoad());
    	

    }
}