import org.w3c.dom.Element;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class CmdCommand extends Command {

	String id;
	String path;
	String args;
	String in;
	String out;
	Element elem;
	String inFile;
	String outFile;

	CmdCommand(Element elem) {
		this.elem = elem;

	}

	public String describe() {
		return "Command: " + path;
	}

	public void execute(String workingDir, Map<String, Command> map)
			throws InterruptedException, IOException {
		List<String> command = new ArrayList<String>();

		Command cmd = map.get(out);
		Command cmd2 = map.get(in);

		boolean b = true;
		if (cmd == null)
			b = false;

		try {
			if (!b)
				throw new ProcessException(
						"Error Processing Batch Unable to locate OUT FileCommand with id: "
								+ out);
		} catch (Exception a) {

			a.printStackTrace();
			System.exit(0);

		}

		outFile = cmd.getPath();

		try {
			inFile = cmd2.getPath();

		} catch (NullPointerException e3) {

		}

		command.add(path);

		if (!(args == null || args.isEmpty())) {
			StringTokenizer st = new StringTokenizer(args);
			while (st.hasMoreTokens()) {
				String tok = st.nextToken();

				command.add(tok);
			}
		}

		if (!("java".equalsIgnoreCase(path) ||"java.exe".equalsIgnoreCase(path)) ) {

			if (!(inFile == null || inFile.isEmpty())) {

				command.add(inFile);

			}
			ProcessBuilder builder = new ProcessBuilder();
			builder.command(command);
			builder.directory(new File(workingDir));

			builder.redirectError(new File(workingDir, "error.txt"));
			builder.redirectOutput(new File(workingDir, outFile));

			Process process = null;

			process = builder.start();

			process.waitFor();

		} else {
			ProcessBuilder builder = new ProcessBuilder(command);
			builder.directory(new File(workingDir));
			File wd = builder.directory();
			final Process process = builder.start();
			OutputStream os = process.getOutputStream();
			FileInputStream fis = new FileInputStream(new File(wd, inFile));

			int achar;
			while ((achar = fis.read()) != -1) {
				os.write(achar);
			}
			os.close();

			File outfile = new File(wd, outFile);
			FileOutputStream fos = new FileOutputStream(outfile);
			InputStream is = process.getInputStream();

			while ((achar = is.read()) != -1) {
				fos.write(achar);

			}
			fos.close();
		}

	}

	public void parse(Element elem) {
		id = elem.getAttribute("id");
		path = elem.getAttribute("path");
		args = elem.getAttribute("args");
		in = elem.getAttribute("in");
		out = elem.getAttribute("out");

	}

	public String getCommandID() {
		return id;
	}

	public String getWorkingDir() {
		return "Not applicable";
	}

	public String getPath() {
		return path;
	}

}
