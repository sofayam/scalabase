import java.io.File

def isJPG(f : File) = {
    val jpgPat = "JPG".r
    jpgPat.findFirstIn(f.getName()).isDefined
}

def newname(d: File,f: File) = {
    val newPath = d.getName() + File.separator + f.getName()
    val p = new File(newPath)
    p
}

def copyfile(tup: Tuple2[File,File]) = {
    println ("copying " + tup._1.getName() + " to " + tup._2.getName() )
}

def dodir(d: File) = {
    // check for JPGs
    val l = d.listFiles.filter(isJPG)
    // create new name
    val newnames = l.map(f => newname(d,f));
    // concat with File.separator
    val jobs = l zip newnames;
    // hand off to copier
    jobs.map(x: Tuple2[File] => copyfile(x));
}

def fl(path: String = ".") = {
    val f = new File(path);
    val l = f.listFiles.filter(_.isDirectory);
    l.map(dodir)
}

