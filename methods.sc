def names(c: Any) = {
    val meths = c.getClass().getMethods()
    val names = meths.map(x => x.getName).sorted.distinct ;

    names.map (x => println(x))
    println (names.length) ;
}

def precis(m: java.lang.reflect.Method) = {
  (java.lang.reflect.Modifier.toString(m.getModifiers), m.getName)
}


def modifs(c: Any) = {
  val modifs = c.getClass().getMethods().map(precis)
  modifs
}


def meths(c: Any) = {
  val meths = c.getClass().getMethods()
  meths
}
