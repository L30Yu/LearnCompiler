
import java_cup.runtime.*;
import java.io.*;

public class parser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\110\000\002\002\004\000\002\002\003\000\002\003" +
    "\004\000\002\004\005\000\002\004\002\000\002\005\003" +
    "\000\002\005\003\000\002\006\007\000\002\007\006\000" +
    "\002\007\002\000\002\010\003\000\002\010\003\000\002" +
    "\010\003\000\002\011\012\000\002\012\004\000\002\013" +
    "\005\000\002\014\004\000\002\014\002\000\002\015\005" +
    "\000\002\015\002\000\002\016\006\000\002\017\005\000" +
    "\002\017\002\000\002\020\005\000\002\020\003\000\002" +
    "\021\010\000\002\021\006\000\002\022\005\000\002\022" +
    "\002\000\002\023\010\000\002\023\006\000\002\023\004" +
    "\000\002\023\005\000\002\023\004\000\002\023\005\000" +
    "\002\024\004\000\002\025\005\000\002\025\003\000\002" +
    "\026\005\000\002\026\003\000\002\027\004\000\002\027" +
    "\005\000\002\027\003\000\002\030\003\000\002\030\003" +
    "\000\002\030\003\000\002\030\003\000\002\030\003\000" +
    "\002\031\005\000\002\031\003\000\002\032\003\000\002" +
    "\032\003\000\002\033\005\000\002\033\003\000\002\034" +
    "\003\000\002\034\003\000\002\035\005\000\002\035\007" +
    "\000\002\035\006\000\002\035\006\000\002\035\006\000" +
    "\002\035\004\000\002\035\003\000\002\035\003\000\002" +
    "\035\003\000\002\035\004\000\002\036\005\000\002\036" +
    "\003\000\002\037\004\000\002\037\002\000\002\040\005" +
    "\000\002\040\002" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\225\000\026\002\ufffd\023\ufffd\032\ufffd\034\ufffd\036" +
    "\ufffd\040\ufffd\042\ufffd\046\004\053\012\055\ufffd\001\002" +
    "\000\004\055\224\001\002\000\004\030\ufffb\001\002\000" +
    "\004\030\ufffc\001\002\000\024\002\uffe5\023\054\024\uffe5" +
    "\032\053\034\050\036\047\040\221\042\057\055\056\001" +
    "\002\000\004\002\216\001\002\000\004\002\000\001\002" +
    "\000\004\055\016\001\002\000\004\030\014\001\002\000" +
    "\032\002\ufffd\023\ufffd\024\ufffd\032\ufffd\034\ufffd\036\ufffd" +
    "\040\ufffd\042\ufffd\046\004\053\012\054\ufffd\055\ufffd\001" +
    "\002\000\026\002\ufffe\023\ufffe\024\ufffe\032\ufffe\034\ufffe" +
    "\036\ufffe\040\ufffe\042\ufffe\054\ufffe\055\ufffe\001\002\000" +
    "\004\021\020\001\002\000\004\027\042\001\002\000\006" +
    "\022\ufff0\055\021\001\002\000\006\025\032\027\uffeb\001" +
    "\002\000\006\022\uffee\031\025\001\002\000\004\022\024" +
    "\001\002\000\004\027\ufff2\001\002\000\004\055\021\001" +
    "\002\000\004\022\ufff1\001\002\000\006\022\uffee\031\025" +
    "\001\002\000\004\022\uffef\001\002\000\004\027\035\001" +
    "\002\000\004\026\033\001\002\000\010\022\uffeb\025\032" +
    "\027\uffeb\001\002\000\006\022\uffec\027\uffec\001\002\000" +
    "\010\043\041\044\040\045\036\001\002\000\012\022\ufff6" +
    "\023\ufff6\030\ufff6\031\ufff6\001\002\000\006\022\uffed\031" +
    "\uffed\001\002\000\012\022\ufff5\023\ufff5\030\ufff5\031\ufff5" +
    "\001\002\000\012\022\ufff7\023\ufff7\030\ufff7\031\ufff7\001" +
    "\002\000\010\043\041\044\040\045\036\001\002\000\004" +
    "\023\044\001\002\000\026\023\ufffd\032\ufffd\034\ufffd\036" +
    "\ufffd\040\ufffd\042\ufffd\046\004\053\012\054\ufffd\055\ufffd" +
    "\001\002\000\004\024\215\001\002\000\022\023\054\032" +
    "\053\034\050\036\047\040\061\042\057\054\uffe5\055\056" +
    "\001\002\000\004\055\056\001\002\000\030\005\074\012" +
    "\102\021\067\047\103\050\104\051\066\052\100\055\075" +
    "\056\070\057\076\060\073\001\002\000\004\024\ufff3\001" +
    "\002\000\004\054\206\001\002\000\030\005\074\012\102" +
    "\021\067\047\103\050\104\051\066\052\100\055\075\056" +
    "\070\057\076\060\073\001\002\000\026\023\ufffd\024\ufffd" +
    "\032\ufffd\034\ufffd\036\ufffd\040\ufffd\042\ufffd\046\004\053" +
    "\012\055\ufffd\001\002\000\004\020\175\001\002\000\012" +
    "\020\ufff8\025\131\030\ufff8\037\ufff8\001\002\000\030\005" +
    "\074\012\102\021\067\047\103\050\104\051\066\052\100" +
    "\055\075\056\070\057\076\060\073\001\002\000\004\030" +
    "\171\001\002\000\020\023\054\032\053\034\050\036\047" +
    "\042\057\054\uffe5\055\056\001\002\000\004\054\063\001" +
    "\002\000\030\005\074\012\102\021\067\047\103\050\104" +
    "\051\066\052\100\055\075\056\070\057\076\060\073\001" +
    "\002\000\042\004\161\005\163\010\uffd7\011\uffd7\013\157" +
    "\014\166\015\164\016\162\017\156\022\uffd7\026\uffd7\030" +
    "\uffd7\031\uffd7\033\uffd7\035\uffd7\037\uffd7\001\002\000\046" +
    "\004\uffcc\005\uffcc\006\uffcc\007\uffcc\010\uffcc\011\uffcc\013" +
    "\uffcc\014\uffcc\015\uffcc\016\uffcc\017\uffcc\022\uffcc\026\uffcc" +
    "\030\uffcc\031\uffcc\033\uffcc\035\uffcc\037\uffcc\001\002\000" +
    "\004\021\153\001\002\000\030\005\074\012\102\021\067" +
    "\047\103\050\104\051\066\052\100\055\075\056\070\057" +
    "\076\060\073\001\002\000\046\004\uffc2\005\uffc2\006\uffc2" +
    "\007\uffc2\010\uffc2\011\uffc2\013\uffc2\014\uffc2\015\uffc2\016" +
    "\uffc2\017\uffc2\022\uffc2\026\uffc2\030\uffc2\031\uffc2\033\uffc2" +
    "\035\uffc2\037\uffc2\001\002\000\024\010\uffda\011\uffda\022" +
    "\uffda\026\uffda\030\uffda\031\uffda\033\uffda\035\uffda\037\uffda" +
    "\001\002\000\046\004\uffd0\005\uffd0\006\146\007\147\010" +
    "\uffd0\011\uffd0\013\uffd0\014\uffd0\015\uffd0\016\uffd0\017\uffd0" +
    "\022\uffd0\026\uffd0\030\uffd0\031\uffd0\033\uffd0\035\uffd0\037" +
    "\uffd0\001\002\000\046\004\uffc1\005\uffc1\006\uffc1\007\uffc1" +
    "\010\uffc1\011\uffc1\013\uffc1\014\uffc1\015\uffc1\016\uffc1\017" +
    "\uffc1\022\uffc1\026\uffc1\030\uffc1\031\uffc1\033\uffc1\035\uffc1" +
    "\037\uffc1\001\002\000\026\005\074\021\067\047\103\050" +
    "\104\051\066\052\100\055\075\056\070\057\076\060\073" +
    "\001\002\000\052\004\ufff8\005\ufff8\006\ufff8\007\ufff8\010" +
    "\ufff8\011\ufff8\013\ufff8\014\ufff8\015\ufff8\016\ufff8\017\ufff8" +
    "\021\126\022\ufff8\025\131\026\ufff8\030\ufff8\031\ufff8\033" +
    "\ufff8\035\ufff8\037\ufff8\001\002\000\046\004\uffc3\005\uffc3" +
    "\006\uffc3\007\uffc3\010\uffc3\011\uffc3\013\uffc3\014\uffc3\015" +
    "\uffc3\016\uffc3\017\uffc3\022\uffc3\026\uffc3\030\uffc3\031\uffc3" +
    "\033\uffc3\035\uffc3\037\uffc3\001\002\000\024\010\112\011" +
    "\uffdc\022\uffdc\026\uffdc\030\uffdc\031\uffdc\033\uffdc\035\uffdc" +
    "\037\uffdc\001\002\000\004\021\123\001\002\000\006\011" +
    "\107\030\121\001\002\000\030\005\074\012\102\021\067" +
    "\047\103\050\104\051\066\052\100\055\075\056\070\057" +
    "\076\060\073\001\002\000\004\021\114\001\002\000\004" +
    "\021\105\001\002\000\030\005\074\012\102\021\067\047" +
    "\103\050\104\051\066\052\100\055\075\056\070\057\076" +
    "\060\073\001\002\000\006\011\107\022\110\001\002\000" +
    "\030\005\074\012\102\021\067\047\103\050\104\051\066" +
    "\052\100\055\075\056\070\057\076\060\073\001\002\000" +
    "\046\004\uffc7\005\uffc7\006\uffc7\007\uffc7\010\uffc7\011\uffc7" +
    "\013\uffc7\014\uffc7\015\uffc7\016\uffc7\017\uffc7\022\uffc7\026" +
    "\uffc7\030\uffc7\031\uffc7\033\uffc7\035\uffc7\037\uffc7\001\002" +
    "\000\024\010\112\011\uffdd\022\uffdd\026\uffdd\030\uffdd\031" +
    "\uffdd\033\uffdd\035\uffdd\037\uffdd\001\002\000\030\005\074" +
    "\012\102\021\067\047\103\050\104\051\066\052\100\055" +
    "\075\056\070\057\076\060\073\001\002\000\024\010\uffdb" +
    "\011\uffdb\022\uffdb\026\uffdb\030\uffdb\031\uffdb\033\uffdb\035" +
    "\uffdb\037\uffdb\001\002\000\004\055\115\001\002\000\006" +
    "\022\uffeb\025\032\001\002\000\004\022\117\001\002\000" +
    "\046\004\uffc8\005\uffc8\006\uffc8\007\uffc8\010\uffc8\011\uffc8" +
    "\013\uffc8\014\uffc8\015\uffc8\016\uffc8\017\uffc8\022\uffc8\026" +
    "\uffc8\030\uffc8\031\uffc8\033\uffc8\035\uffc8\037\uffc8\001\002" +
    "\000\024\010\uffd9\011\uffd9\022\uffd9\026\uffd9\030\uffd9\031" +
    "\uffd9\033\uffd9\035\uffd9\037\uffd9\001\002\000\004\041\122" +
    "\001\002\000\004\024\uffe8\001\002\000\030\005\074\012" +
    "\102\021\067\047\103\050\104\051\066\052\100\055\075" +
    "\056\070\057\076\060\073\001\002\000\006\011\107\022" +
    "\125\001\002\000\046\004\uffc5\005\uffc5\006\uffc5\007\uffc5" +
    "\010\uffc5\011\uffc5\013\uffc5\014\uffc5\015\uffc5\016\uffc5\017" +
    "\uffc5\022\uffc5\026\uffc5\030\uffc5\031\uffc5\033\uffc5\035\uffc5" +
    "\037\uffc5\001\002\000\032\005\074\012\102\021\067\022" +
    "\uffbc\047\103\050\104\051\066\052\100\055\075\056\070" +
    "\057\076\060\073\001\002\000\046\004\uffc4\005\uffc4\006" +
    "\uffc4\007\uffc4\010\uffc4\011\uffc4\013\uffc4\014\uffc4\015\uffc4" +
    "\016\uffc4\017\uffc4\022\uffc4\026\uffc4\030\uffc4\031\uffc4\033" +
    "\uffc4\035\uffc4\037\uffc4\001\002\000\046\004\uffbe\005\uffbe" +
    "\006\uffbe\007\uffbe\010\uffbe\011\uffbe\013\uffbe\014\uffbe\015" +
    "\uffbe\016\uffbe\017\uffbe\022\uffbe\026\uffbe\030\uffbe\031\uffbe" +
    "\033\uffbe\035\uffbe\037\uffbe\001\002\000\030\005\074\012" +
    "\102\021\067\047\103\050\104\051\066\052\100\055\075" +
    "\056\070\057\076\060\073\001\002\000\006\011\107\026" +
    "\133\001\002\000\054\004\ufff8\005\ufff8\006\ufff8\007\ufff8" +
    "\010\ufff8\011\ufff8\013\ufff8\014\ufff8\015\ufff8\016\ufff8\017" +
    "\ufff8\020\ufff8\022\ufff8\025\131\026\ufff8\027\ufff8\030\ufff8" +
    "\031\ufff8\033\ufff8\035\ufff8\037\ufff8\001\002\000\052\004" +
    "\ufff9\005\ufff9\006\ufff9\007\ufff9\010\ufff9\011\ufff9\013\ufff9" +
    "\014\ufff9\015\ufff9\016\ufff9\017\ufff9\020\ufff9\022\ufff9\026" +
    "\ufff9\027\ufff9\030\ufff9\031\ufff9\033\ufff9\035\ufff9\037\ufff9" +
    "\001\002\000\010\011\107\022\uffba\031\140\001\002\000" +
    "\004\022\137\001\002\000\046\004\uffbf\005\uffbf\006\uffbf" +
    "\007\uffbf\010\uffbf\011\uffbf\013\uffbf\014\uffbf\015\uffbf\016" +
    "\uffbf\017\uffbf\022\uffbf\026\uffbf\030\uffbf\031\uffbf\033\uffbf" +
    "\035\uffbf\037\uffbf\001\002\000\030\005\074\012\102\021" +
    "\067\047\103\050\104\051\066\052\100\055\075\056\070" +
    "\057\076\060\073\001\002\000\004\022\uffbd\001\002\000" +
    "\010\011\107\022\uffba\031\140\001\002\000\004\022\uffbb" +
    "\001\002\000\046\004\uffc0\005\uffc0\006\uffc0\007\uffc0\010" +
    "\uffc0\011\uffc0\013\uffc0\014\uffc0\015\uffc0\016\uffc0\017\uffc0" +
    "\022\uffc0\026\uffc0\030\uffc0\031\uffc0\033\uffc0\035\uffc0\037" +
    "\uffc0\001\002\000\026\005\074\021\067\047\103\050\104" +
    "\051\066\052\100\055\075\056\070\057\076\060\073\001" +
    "\002\000\026\005\uffcb\021\uffcb\047\uffcb\050\uffcb\051\uffcb" +
    "\052\uffcb\055\uffcb\056\uffcb\057\uffcb\060\uffcb\001\002\000" +
    "\026\005\uffca\021\uffca\047\uffca\050\uffca\051\uffca\052\uffca" +
    "\055\uffca\056\uffca\057\uffca\060\uffca\001\002\000\046\004" +
    "\uffcd\005\uffcd\006\uffcd\007\uffcd\010\uffcd\011\uffcd\013\uffcd" +
    "\014\uffcd\015\uffcd\016\uffcd\017\uffcd\022\uffcd\026\uffcd\030" +
    "\uffcd\031\uffcd\033\uffcd\035\uffcd\037\uffcd\001\002\000\006" +
    "\011\107\022\152\001\002\000\046\004\uffc9\005\uffc9\006" +
    "\uffc9\007\uffc9\010\uffc9\011\uffc9\013\uffc9\014\uffc9\015\uffc9" +
    "\016\uffc9\017\uffc9\022\uffc9\026\uffc9\030\uffc9\031\uffc9\033" +
    "\uffc9\035\uffc9\037\uffc9\001\002\000\030\005\074\012\102" +
    "\021\067\047\103\050\104\051\066\052\100\055\075\056" +
    "\070\057\076\060\073\001\002\000\006\011\107\022\155" +
    "\001\002\000\046\004\uffc6\005\uffc6\006\uffc6\007\uffc6\010" +
    "\uffc6\011\uffc6\013\uffc6\014\uffc6\015\uffc6\016\uffc6\017\uffc6" +
    "\022\uffc6\026\uffc6\030\uffc6\031\uffc6\033\uffc6\035\uffc6\037" +
    "\uffc6\001\002\000\026\005\uffd2\021\uffd2\047\uffd2\050\uffd2" +
    "\051\uffd2\052\uffd2\055\uffd2\056\uffd2\057\uffd2\060\uffd2\001" +
    "\002\000\026\005\uffd6\021\uffd6\047\uffd6\050\uffd6\051\uffd6" +
    "\052\uffd6\055\uffd6\056\uffd6\057\uffd6\060\uffd6\001\002\000" +
    "\026\005\074\021\067\047\103\050\104\051\066\052\100" +
    "\055\075\056\070\057\076\060\073\001\002\000\026\005" +
    "\uffcf\021\uffcf\047\uffcf\050\uffcf\051\uffcf\052\uffcf\055\uffcf" +
    "\056\uffcf\057\uffcf\060\uffcf\001\002\000\026\005\uffd3\021" +
    "\uffd3\047\uffd3\050\uffd3\051\uffd3\052\uffd3\055\uffd3\056\uffd3" +
    "\057\uffd3\060\uffd3\001\002\000\026\005\uffce\021\uffce\047" +
    "\uffce\050\uffce\051\uffce\052\uffce\055\uffce\056\uffce\057\uffce" +
    "\060\uffce\001\002\000\026\005\uffd4\021\uffd4\047\uffd4\050" +
    "\uffd4\051\uffd4\052\uffd4\055\uffd4\056\uffd4\057\uffd4\060\uffd4" +
    "\001\002\000\026\005\074\021\067\047\103\050\104\051" +
    "\066\052\100\055\075\056\070\057\076\060\073\001\002" +
    "\000\026\005\uffd5\021\uffd5\047\uffd5\050\uffd5\051\uffd5\052" +
    "\uffd5\055\uffd5\056\uffd5\057\uffd5\060\uffd5\001\002\000\046" +
    "\004\uffd1\005\uffd1\006\146\007\147\010\uffd1\011\uffd1\013" +
    "\uffd1\014\uffd1\015\uffd1\016\uffd1\017\uffd1\022\uffd1\026\uffd1" +
    "\030\uffd1\031\uffd1\033\uffd1\035\uffd1\037\uffd1\001\002\000" +
    "\030\004\161\005\163\010\uffd8\011\uffd8\022\uffd8\026\uffd8" +
    "\030\uffd8\031\uffd8\033\uffd8\035\uffd8\037\uffd8\001\002\000" +
    "\026\002\uffe5\023\054\024\uffe5\032\053\034\050\036\047" +
    "\041\uffe5\042\057\054\uffe5\055\056\001\002\000\012\002" +
    "\uffe6\024\uffe6\041\uffe6\054\uffe6\001\002\000\010\011\107" +
    "\030\uffe0\037\uffe0\001\002\000\010\020\uffde\030\uffde\037" +
    "\uffde\001\002\000\030\005\074\012\102\021\067\047\103" +
    "\050\104\051\066\052\100\055\075\056\070\057\076\060" +
    "\073\001\002\000\010\011\107\030\uffe1\037\uffe1\001\002" +
    "\000\004\024\200\001\002\000\006\030\uffdf\037\uffdf\001" +
    "\002\000\006\011\107\033\202\001\002\000\016\023\054" +
    "\032\053\034\050\036\047\042\057\055\056\001\002\000" +
    "\004\037\204\001\002\000\016\023\054\032\053\034\050" +
    "\036\047\042\057\055\056\001\002\000\006\030\uffe4\037" +
    "\uffe4\001\002\000\030\005\074\012\102\021\067\047\103" +
    "\050\104\051\066\052\100\055\075\056\070\057\076\060" +
    "\073\001\002\000\006\011\107\030\210\001\002\000\004" +
    "\024\uffe7\001\002\000\006\011\107\035\212\001\002\000" +
    "\016\023\054\032\053\034\050\036\047\042\057\055\056" +
    "\001\002\000\006\030\uffe3\037\uffe3\001\002\000\006\030" +
    "\uffe2\037\uffe2\001\002\000\004\030\ufff4\001\002\000\004" +
    "\002\001\001\002\000\006\002\uffff\024\uffff\001\002\000" +
    "\006\002\uffe9\024\uffe9\001\002\000\020\023\054\032\053" +
    "\034\050\036\047\041\uffe5\042\057\055\056\001\002\000" +
    "\004\041\223\001\002\000\006\002\uffea\024\uffea\001\002" +
    "\000\006\025\131\027\ufff8\001\002\000\004\027\226\001" +
    "\002\000\010\043\041\044\040\045\036\001\002\000\004" +
    "\030\ufffa\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\225\000\016\002\007\003\010\004\006\005\012\006" +
    "\005\011\004\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\012\020\216\022\217\023\057\024" +
    "\054\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\012\004\014\005\012\006" +
    "\005\011\004\001\001\000\002\001\001\000\004\013\016" +
    "\001\001\000\002\001\001\000\006\014\022\016\021\001" +
    "\001\000\004\017\030\001\001\000\004\015\025\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\016\026\001" +
    "\001\000\002\001\001\000\004\015\027\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\017" +
    "\033\001\001\000\002\001\001\000\004\010\036\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\010\042\001\001\000\002\001\001" +
    "\000\014\004\045\005\012\006\005\011\004\012\044\001" +
    "\001\000\002\001\001\000\012\021\050\022\051\023\057" +
    "\024\054\001\001\000\004\024\213\001\001\000\016\025" +
    "\210\026\076\027\070\031\063\033\071\035\064\001\001" +
    "\000\002\001\001\000\002\001\001\000\016\025\200\026" +
    "\076\027\070\031\063\033\071\035\064\001\001\000\014" +
    "\003\176\004\006\005\012\006\005\011\004\001\001\000" +
    "\002\001\001\000\004\007\173\001\001\000\016\025\172" +
    "\026\076\027\070\031\063\033\071\035\064\001\001\000" +
    "\002\001\001\000\010\022\061\023\057\024\054\001\001" +
    "\000\002\001\001\000\016\025\100\026\076\027\070\031" +
    "\063\033\071\035\064\001\001\000\006\030\157\032\164" +
    "\001\001\000\002\001\001\000\002\001\001\000\016\025" +
    "\150\026\076\027\070\031\063\033\071\035\064\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\034\144\001" +
    "\001\000\002\001\001\000\004\035\143\001\001\000\006" +
    "\007\127\036\126\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\012\027\117" +
    "\031\063\033\071\035\064\001\001\000\002\001\001\000" +
    "\002\001\001\000\016\025\105\026\076\027\070\031\063" +
    "\033\071\035\064\001\001\000\002\001\001\000\014\026" +
    "\110\027\070\031\063\033\071\035\064\001\001\000\002" +
    "\001\001\000\002\001\001\000\012\027\112\031\063\033" +
    "\071\035\064\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\017\115\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\016\025\123\026\076\027\070\031\063\033\071\035" +
    "\064\001\001\000\002\001\001\000\002\001\001\000\020" +
    "\025\134\026\076\027\070\031\063\033\071\035\064\037" +
    "\135\001\001\000\002\001\001\000\002\001\001\000\016" +
    "\025\131\026\076\027\070\031\063\033\071\035\064\001" +
    "\001\000\002\001\001\000\004\007\133\001\001\000\002" +
    "\001\001\000\004\040\140\001\001\000\002\001\001\000" +
    "\002\001\001\000\016\025\141\026\076\027\070\031\063" +
    "\033\071\035\064\001\001\000\002\001\001\000\004\040" +
    "\142\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\035\147\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\016" +
    "\025\153\026\076\027\070\031\063\033\071\035\064\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\010\031\167\033\071\035\064\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\006\033\166\035\064\001\001\000" +
    "\002\001\001\000\004\034\144\001\001\000\004\032\164" +
    "\001\001\000\010\022\171\023\057\024\054\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\016" +
    "\025\175\026\076\027\070\031\063\033\071\035\064\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\006\023\202\024\054\001\001\000" +
    "\002\001\001\000\006\023\204\024\054\001\001\000\002" +
    "\001\001\000\016\025\206\026\076\027\070\031\063\033" +
    "\071\035\064\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\006\023\212\024\054\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\010\022" +
    "\221\023\057\024\054\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\007\224\001\001\000\002\001\001\000" +
    "\004\010\226\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




  public static void main(String[] args) {
    try {
      System.out.println("Parsing ["+args[0]+"]");
      // create a buffering scanner wrapper
      Scanner lexer = new m_lexor( new java.io.FileReader(args[0]));
      // start parsing
      parser p = new parser(lexer);
      Node start = (Node) p.parse().value;
      System.out.println("AST: ");
      String astString = "M_prog (\n";
      astString += start.toString();
      astString += ")\n";

      System.out.println(astString);
      
      String amFileName = args[0].replace(".m+", ".am");
      File amFile = new File(amFileName);
      PrintWriter AM = new PrintWriter(amFile);
      
      SymbolChecker sc = new SymbolChecker(start, AM);
      if (sc.checkSyntax()) {
    	  System.out.println("Semantics are good");
    	  AM.close();
    	  System.out.println("AM file created: "+amFileName);
      }
      else {
    	  System.out.println("Semantics are not good");
    	  AM.close();
    	  amFile.delete();
      }
    }
    catch (Exception e) {
		e.printStackTrace();
    }
  }

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
 {
        return CUP$parser$do_action1(
             CUP$parser$act_num, CUP$parser$parser,CUP$parser$stack,CUP$parser$top);
      }
    }


  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$parser$do_action1(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= prog EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Node start_val = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // prog ::= block 
            {
              Node RESULT =null;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node b = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(b); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("prog",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // block ::= declarations program_body 
            {
              Node RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Node d = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int pleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int pright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node p = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(d, p); RESULT.name = "M_block";  
              CUP$parser$result = parser.getSymbolFactory().newSymbol("block",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // declarations ::= declaration SEMICLON declarations 
            {
              Node RESULT =null;
		int d1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int d1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Node d1 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object s = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int d2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int d2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node d2 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(d1, d2); RESULT.name = "M_decls";
              CUP$parser$result = parser.getSymbolFactory().newSymbol("declarations",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // declarations ::= 
            {
              Node RESULT =null;
		 RESULT = new Node(); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("declarations",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // declaration ::= var_declaration 
            {
              Node RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int vright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node v = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(v); RESULT.name = "M_var_decl"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("declaration",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // declaration ::= fun_declaration 
            {
              Node RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node f = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(f); RESULT.name = "M_fun_decl"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("declaration",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // var_declaration ::= VAR ID array_dimensions COLON type 
            {
              Node RESULT =null;
		int valeft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int varight = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		Object va = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int ileft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		Object i = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int adleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int adright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Node ad = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object c = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node t = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(i,ad, t);  RESULT.name = "M_var";
              CUP$parser$result = parser.getSymbolFactory().newSymbol("var_declaration",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // array_dimensions ::= SLPAR expr SRPAR array_dimensions 
            {
              Node RESULT =null;
		int slleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int slright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		Object sl = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Node e = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int srleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int srright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object sr = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int adleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int adright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node ad = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(e, ad);  RESULT.name = "M_array_dim"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("array_dimensions",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // array_dimensions ::= 
            {
              Node RESULT =null;
		 RESULT = new Node(); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("array_dimensions",5, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // type ::= INT 
            {
              Node RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int iright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object i = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(i);  RESULT.name = "M_int"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("type",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // type ::= REAL 
            {
              Node RESULT =null;
		int rleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int rright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object r = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(r);  RESULT.name = "M_real"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("type",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // type ::= BOOL 
            {
              Node RESULT =null;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object b = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(b);  RESULT.name = "M_bool"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("type",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // fun_declaration ::= FUN ID param_list COLON type CLPAR fun_block CRPAR 
            {
              Node RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-7)).left;
		int fright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-7)).right;
		Object f = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-7)).value;
		int idleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)).right;
		Object id = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-6)).value;
		int plleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).left;
		int plright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).right;
		Node pl = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-5)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		Object c = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		Node t = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int clpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int clpright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Object clp = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int fbleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int fbright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Node fb = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int crpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int crpright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object crp = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(id, pl, t, fb); RESULT.name = "M_fun";  
              CUP$parser$result = parser.getSymbolFactory().newSymbol("fun_declaration",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-7)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // fun_block ::= declarations fun_body 
            {
              Node RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Node d = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int fbleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int fbright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node fb = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(d, fb); RESULT.name = "F_block"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("fun_block",8, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // param_list ::= LPAR parameters RPAR 
            {
              Node RESULT =null;
		int lpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int lpright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Object lp = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int pleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int pright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Node p = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int rpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int rpright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object rp = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(p); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("param_list",9, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // parameters ::= basic_declaration more_parameters 
            {
              Node RESULT =null;
		int bdleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int bdright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Node bd = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int mpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int mpright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node mp = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(bd, mp);  RESULT.name = "F_param"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("parameters",10, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // parameters ::= 
            {
              Node RESULT =null;
		 RESULT = new Node(); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("parameters",10, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // more_parameters ::= COMMA basic_declaration more_parameters 
            {
              Node RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Object c = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bdleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int bdright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Node bd = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int mpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int mpright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node mp = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(bd, mp); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("more_parameters",11, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // more_parameters ::= 
            {
              Node RESULT =null;
		 RESULT = new Node(); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("more_parameters",11, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // basic_declaration ::= ID basic_array_dimensions COLON type 
            {
              Node RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		Object id = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int badleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int badright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Node bad = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object c = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node t = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(id, bad, t); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("basic_declaration",12, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // basic_array_dimensions ::= SLPAR SRPAR basic_array_dimensions 
            {
              Node RESULT =null;
		int slpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int slpright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Object slp = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int srpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int srpright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object srp = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int badleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int badright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node bad = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(bad);   RESULT.name = "F_param_dim"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("basic_array_dimensions",13, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // basic_array_dimensions ::= 
            {
              Node RESULT =null;
		 RESULT = new Node(); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("basic_array_dimensions",13, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // program_body ::= BEGIN prog_stmts END 
            {
              Node RESULT =null;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Object b = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int psleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int psright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Node ps = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int edleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int edright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object ed = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(ps); RESULT.name = "P_body"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("program_body",14, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // program_body ::= prog_stmts 
            {
              Node RESULT =null;
		int psleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int psright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node ps = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(ps); RESULT.name = "P_body"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("program_body",14, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // fun_body ::= BEGIN prog_stmts RETURN expr SEMICLON END 
            {
              Node RESULT =null;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).right;
		Object b = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-5)).value;
		int psleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int psright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		Node ps = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int rleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int rright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		Object r = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int epleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int epright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Node ep = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object s = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object e = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(ps, ep);  RESULT.name = "F_body"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("fun_body",15, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // fun_body ::= prog_stmts RETURN expr SEMICLON 
            {
              Node RESULT =null;
		int psleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int psright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		Node ps = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int rleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int rright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Object r = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int epleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int epright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Node ep = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object s = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(ps, ep); RESULT.name = "F_body";  
              CUP$parser$result = parser.getSymbolFactory().newSymbol("fun_body",15, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // prog_stmts ::= prog_stmt SEMICLON prog_stmts 
            {
              Node RESULT =null;
		int psleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int psright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Node ps = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object s = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int pssleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int pssright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node pss = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(ps, pss);  RESULT.name = "P_stmts";
              CUP$parser$result = parser.getSymbolFactory().newSymbol("prog_stmts",16, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // prog_stmts ::= 
            {
              Node RESULT =null;
		 RESULT = new Node(); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("prog_stmts",16, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // prog_stmt ::= IF expr THEN prog_stmt ELSE prog_stmt 
            {
              Node RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).right;
		Object i = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-5)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		Node e = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		Object t = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int psleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int psright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Node ps = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int esleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int esright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object es = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int ps2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int ps2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node ps2 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(e, ps, ps2); RESULT.name = "M_cond"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("prog_stmt",17, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // prog_stmt ::= WHILE expr DO prog_stmt 
            {
              Node RESULT =null;
		int wleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int wright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		Object w = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int epleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int epright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Node ep = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object d = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int psleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int psright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node ps = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(ep, ps); RESULT.name = "M_while";  
              CUP$parser$result = parser.getSymbolFactory().newSymbol("prog_stmt",17, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // prog_stmt ::= READ identifier 
            {
              Node RESULT =null;
		int rleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int rright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object r = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int lleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int lright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node l = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(l); RESULT.name = "M_read";  
              CUP$parser$result = parser.getSymbolFactory().newSymbol("prog_stmt",17, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // prog_stmt ::= identifier ASSIGN expr 
            {
              Node RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Node l = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node e = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(l, e); RESULT.name = "M_ass";  
              CUP$parser$result = parser.getSymbolFactory().newSymbol("prog_stmt",17, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // prog_stmt ::= PRINT expr 
            {
              Node RESULT =null;
		int pleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int pright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object p = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node e = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(e); RESULT.name = "M_print";   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("prog_stmt",17, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 34: // prog_stmt ::= CLPAR block CRPAR 
            {
              Node RESULT =null;
		int clpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int clpright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Object clp = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Node b = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int crpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int crpright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object crp = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(b);  RESULT.name = "M_stmt_block"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("prog_stmt",17, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 35: // identifier ::= ID array_dimensions 
            {
              Node RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object i = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int adleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int adright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node ad = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(i, ad); RESULT.name = "M_location"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("identifier",18, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 36: // expr ::= expr OR bint_term 
            {
              Node RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Node e = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int oleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int oright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object o = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int btleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int btright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node bt = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(e, bt); RESULT.name = "M_or";
              CUP$parser$result = parser.getSymbolFactory().newSymbol("expr",19, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 37: // expr ::= bint_term 
            {
              Node RESULT =null;
		int btleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int btright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node bt = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(bt);  RESULT.name += "M_expr";
              CUP$parser$result = parser.getSymbolFactory().newSymbol("expr",19, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 38: // bint_term ::= bint_term AND bint_factor 
            {
              Node RESULT =null;
		int btleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int btright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Node bt = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int bfleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bfright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node bf = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(bt, bf); RESULT.name = "M_and";
              CUP$parser$result = parser.getSymbolFactory().newSymbol("bint_term",20, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 39: // bint_term ::= bint_factor 
            {
              Node RESULT =null;
		int bfleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bfright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node bf = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(bf);   RESULT.name += "M_expr";
              CUP$parser$result = parser.getSymbolFactory().newSymbol("bint_term",20, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 40: // bint_factor ::= NOT bint_factor 
            {
              Node RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int nright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object n = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int bfleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bfright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node bf = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(bf); RESULT.name = "M_not";
              CUP$parser$result = parser.getSymbolFactory().newSymbol("bint_factor",21, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 41: // bint_factor ::= int_expr compare_op int_expr 
            {
              Node RESULT =null;
		int ieleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int ieright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Node ie = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int coleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int coright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Node co = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int ie2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int ie2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node ie2 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(ie, co, ie2); RESULT.name = "M_comp"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("bint_factor",21, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 42: // bint_factor ::= int_expr 
            {
              Node RESULT =null;
		int ieleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int ieright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node ie = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(ie);   RESULT.name += "M_expr";
              CUP$parser$result = parser.getSymbolFactory().newSymbol("bint_factor",21, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 43: // compare_op ::= EQUAL 
            {
              Node RESULT =null;
		int eqleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int eqright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object eq = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(eq); RESULT.name = "M_eq";  
              CUP$parser$result = parser.getSymbolFactory().newSymbol("compare_op",22, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 44: // compare_op ::= LT 
            {
              Node RESULT =null;
		int ltleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int ltright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object lt = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(lt); RESULT.name = "M_lt";  
              CUP$parser$result = parser.getSymbolFactory().newSymbol("compare_op",22, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 45: // compare_op ::= GT 
            {
              Node RESULT =null;
		int gtleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int gtright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object gt = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(gt); RESULT.name = "M_gt";  
              CUP$parser$result = parser.getSymbolFactory().newSymbol("compare_op",22, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 46: // compare_op ::= LE 
            {
              Node RESULT =null;
		int leleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int leright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object le = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(le); RESULT.name = "M_le";  
              CUP$parser$result = parser.getSymbolFactory().newSymbol("compare_op",22, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 47: // compare_op ::= GE 
            {
              Node RESULT =null;
		int geleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int geright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object ge = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(ge); RESULT.name = "M_ge";  
              CUP$parser$result = parser.getSymbolFactory().newSymbol("compare_op",22, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 48: // int_expr ::= int_expr addop int_term 
            {
              Node RESULT =null;
		int ieleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int ieright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Node ie = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Node a = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int itleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int itright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node it = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(ie, a, it);  RESULT.name = "M_addop"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("int_expr",23, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 49: // int_expr ::= int_term 
            {
              Node RESULT =null;
		int itleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int itright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node it = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(it);   RESULT.name += "M_expr";
              CUP$parser$result = parser.getSymbolFactory().newSymbol("int_expr",23, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 50: // addop ::= ADD 
            {
              Node RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(a); RESULT.name = "M_add";   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("addop",24, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 51: // addop ::= SUB 
            {
              Node RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object s = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(s);  RESULT.name = "M_sub";  
              CUP$parser$result = parser.getSymbolFactory().newSymbol("addop",24, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 52: // int_term ::= int_term mulop int_factor 
            {
              Node RESULT =null;
		int itleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int itright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Node it = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int mleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int mright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Node m = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node f = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(it, m, f); RESULT.name = "M_mulop"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("int_term",25, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 53: // int_term ::= int_factor 
            {
              Node RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node f = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(f);   RESULT.name += "M_expr";
              CUP$parser$result = parser.getSymbolFactory().newSymbol("int_term",25, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 54: // mulop ::= MUL 
            {
              Node RESULT =null;
		int mleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int mright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object m = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(m);  RESULT.name = "M_mul";  
              CUP$parser$result = parser.getSymbolFactory().newSymbol("mulop",26, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 55: // mulop ::= DIV 
            {
              Node RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object d = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(d);  RESULT.name = "M_div";  
              CUP$parser$result = parser.getSymbolFactory().newSymbol("mulop",26, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 56: // int_factor ::= LPAR expr RPAR 
            {
              Node RESULT =null;
		int lpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int lpright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Object lp = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Node e = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int rpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int rpright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object rp = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(e);   RESULT.name += "M_expr";
              CUP$parser$result = parser.getSymbolFactory().newSymbol("int_factor",27, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 57: // int_factor ::= SIZE LPAR ID basic_array_dimensions RPAR 
            {
              Node RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		Object s = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int lpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int lpright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		Object lp = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int ileft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Object i = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int badleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int badright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Node bad = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int rpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int rpright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object rp = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(i, bad);  RESULT.name = "M_size"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("int_factor",27, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 58: // int_factor ::= FLOAT LPAR expr RPAR 
            {
              Node RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int fright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		Object f = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int lpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int lpright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Object lp = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Node e = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int rpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int rpright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object rp = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(e); RESULT.name = "M_float"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("int_factor",27, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 59: // int_factor ::= FLOOR LPAR expr RPAR 
            {
              Node RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int fright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		Object f = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int lpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int lpright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Object lp = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Node e = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int rpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int rpright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object rp = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(e); RESULT.name = "M_floor";
              CUP$parser$result = parser.getSymbolFactory().newSymbol("int_factor",27, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 60: // int_factor ::= CEIL LPAR expr RPAR 
            {
              Node RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		Object c = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int lpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int lpright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Object lp = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Node e = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int rpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int rpright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object rp = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(e); RESULT.name = "M_ceil";
              CUP$parser$result = parser.getSymbolFactory().newSymbol("int_factor",27, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 61: // int_factor ::= ID modifier_list 
            {
              Node RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object i = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int mlleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int mlright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node ml = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(i, ml); RESULT.name = "M_id"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("int_factor",27, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 62: // int_factor ::= IVAL 
            {
              Node RESULT =null;
		int IVALleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int IVALright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object IVAL = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(IVAL);  RESULT.name = "M_ival"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("int_factor",27, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 63: // int_factor ::= RVAL 
            {
              Node RESULT =null;
		int RVALleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int RVALright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object RVAL = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(RVAL);  RESULT.name = "M_rval"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("int_factor",27, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 64: // int_factor ::= BVAL 
            {
              Node RESULT =null;
		int BVALleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int BVALright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object BVAL = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(BVAL);  RESULT.name = "M_bval"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("int_factor",27, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 65: // int_factor ::= SUB int_factor 
            {
              Node RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object s = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int ileft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int iright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node i = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(i); RESULT.name = "M_neg"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("int_factor",27, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 66: // modifier_list ::= LPAR arguments RPAR 
            {
              Node RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Object l = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int falleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int falright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Node fal = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int rleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int rright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object r = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(fal); RESULT.name = "M_fn";
              CUP$parser$result = parser.getSymbolFactory().newSymbol("modifier_list",28, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 67: // modifier_list ::= array_dimensions 
            {
              Node RESULT =null;
		int adleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int adright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node ad = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(ad); RESULT.name = "M_dim"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("modifier_list",28, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 68: // arguments ::= expr more_arguments 
            {
              Node RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Node e = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int maleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int maright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node ma = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(e, ma); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("arguments",29, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 69: // arguments ::= 
            {
              Node RESULT =null;
		 RESULT = new Node(); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("arguments",29, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 70: // more_arguments ::= COMMA expr more_arguments 
            {
              Node RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Object c = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Node e = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int maleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int maright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node ma = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Node(e, ma); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("more_arguments",30, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 71: // more_arguments ::= 
            {
              Node RESULT =null;
		 RESULT = new Node(); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("more_arguments",30, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

