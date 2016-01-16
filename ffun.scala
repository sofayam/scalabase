import java.io.File

def isJPG(f : File) = {
    val jpgPat = "JPG".r
    jpgPat.findFirstIn(f.getName()).isDefined
}

def newname(d: File,f: File) = {
  val newPath = "./res/" + d.getName() + "_" + f.getName()
  println(newPath)
  val p = new File(newPath)
  p
}

def copyfile(oldf: File, newf: File) = {
  println ("copying " + oldf.getPath() + " to " + newf.getPath() )
}

def dodir(d: File) = {
    // check for JPGs
    val l = d.listFiles.filter(isJPG)
    // create new name
    val newnames = l.map(f => newname(d,f));
    // concat with File.separator
    val jobs = l zip newnames;
    println(jobs)
    // hand off to copier
    for ((oldf, newf) <- jobs) {
    	copyfile(oldf, newf)
    }
}

def fl(path: String = ".") = {
    val f = new File(path);
    val l = f.listFiles.filter(_.isDirectory);
    l.map(dodir)
}

