import java.io.File
import sys.process._

def isPhoto(f : File) = {
  val isjpg = "JPG".r.findFirstIn(f.getName()).isDefined
  val ispng = "PNG".r.findFirstIn(f.getName()).isDefined
  isjpg | ispng
}

def newname(d: File,f: File) = {
  val newPath = "./res/" + d.getName() + "_" + f.getName()
  // println(newPath)
  val p = new File(newPath)
  p
}

def copyfile(oldf: File, newf: File) = {
  //println ("copying " + oldf.getPath() + " to " + newf.getPath() )
  val cmd = "cp " + oldf.getPath() + " " + newf.getPath()
  println(cmd)
  cmd.!
}

def dodir(d: File) = {
  // check for JPGs
  val l = d.listFiles.filter(isPhoto)
  // create new name
  val newnames = l.map(f => newname(d,f));
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

