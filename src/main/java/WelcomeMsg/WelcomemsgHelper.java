package WelcomeMsg;


/**
* WelcomeMsg/WelcomemsgHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WelcomeMsg.idl
* Friday 21 August 2020 at 00:01:34 British Summer Time
*/

abstract public class WelcomemsgHelper
{
  private static String  _id = "IDL:WelcomeMsg/Welcomemsg:1.0";

  public static void insert (org.omg.CORBA.Any a, WelcomeMsg.Welcomemsg that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static WelcomeMsg.Welcomemsg extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (WelcomeMsg.WelcomemsgHelper.id (), "Welcomemsg");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static WelcomeMsg.Welcomemsg read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_WelcomemsgStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, WelcomeMsg.Welcomemsg value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static WelcomeMsg.Welcomemsg narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof WelcomeMsg.Welcomemsg)
      return (WelcomeMsg.Welcomemsg)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      WelcomeMsg._WelcomemsgStub stub = new WelcomeMsg._WelcomemsgStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static WelcomeMsg.Welcomemsg unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof WelcomeMsg.Welcomemsg)
      return (WelcomeMsg.Welcomemsg)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      WelcomeMsg._WelcomemsgStub stub = new WelcomeMsg._WelcomemsgStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
