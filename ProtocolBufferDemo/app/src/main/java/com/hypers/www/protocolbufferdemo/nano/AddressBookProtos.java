// Generated by the protocol buffer compiler.  DO NOT EDIT!

package com.hypers.www.protocolbufferdemo.nano;

@SuppressWarnings("hiding")
public interface AddressBookProtos {

  public static final class Person extends
      com.google.protobuf.nano.MessageNano {

    // enum PhoneType
    public static final int MOBILE = 0;
    public static final int HOME = 1;
    public static final int WORK = 2;

    public static final class PhoneNumber extends
        com.google.protobuf.nano.MessageNano {

      private static volatile PhoneNumber[] _emptyArray;
      public static PhoneNumber[] emptyArray() {
        // Lazily initializes the empty array
        if (_emptyArray == null) {
          synchronized (
              com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
            if (_emptyArray == null) {
              _emptyArray = new PhoneNumber[0];
            }
          }
        }
        return _emptyArray;
      }

      // string number = 1;
      public String number;

      // .Person.PhoneType type = 2;
      public int type;

      public PhoneNumber() {
        clear();
      }

      public PhoneNumber clear() {
        number = "";
        type = Person.MOBILE;
        cachedSize = -1;
        return this;
      }

      @Override
      public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
          throws java.io.IOException {
        if (!this.number.equals("")) {
          output.writeString(1, this.number);
        }
        if (this.type != Person.MOBILE) {
          output.writeInt32(2, this.type);
        }
        super.writeTo(output);
      }

      @Override
      protected int computeSerializedSize() {
        int size = super.computeSerializedSize();
        if (!this.number.equals("")) {
          size += com.google.protobuf.nano.CodedOutputByteBufferNano
              .computeStringSize(1, this.number);
        }
        if (this.type != Person.MOBILE) {
          size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeInt32Size(2, this.type);
        }
        return size;
      }

      @Override
      public PhoneNumber mergeFrom(
              com.google.protobuf.nano.CodedInputByteBufferNano input)
          throws java.io.IOException {
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              return this;
            default: {
              if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
                return this;
              }
              break;
            }
            case 10: {
              this.number = input.readString();
              break;
            }
            case 16: {
              int value = input.readInt32();
              switch (value) {
                case Person.MOBILE:
                case Person.HOME:
                case Person.WORK:
                  this.type = value;
                  break;
              }
              break;
            }
          }
        }
      }

      public static PhoneNumber parseFrom(byte[] data)
          throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
        return com.google.protobuf.nano.MessageNano.mergeFrom(new PhoneNumber(), data);
      }

      public static PhoneNumber parseFrom(
              com.google.protobuf.nano.CodedInputByteBufferNano input)
          throws java.io.IOException {
        return new PhoneNumber().mergeFrom(input);
      }
    }

    private static volatile Person[] _emptyArray;
    public static Person[] emptyArray() {
      // Lazily initializes the empty array
      if (_emptyArray == null) {
        synchronized (
            com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
          if (_emptyArray == null) {
            _emptyArray = new Person[0];
          }
        }
      }
      return _emptyArray;
    }

    // string name = 1;
    public String name;

    // int32 id = 2;
    public int id;

    // string email = 3;
    public String email;

    // repeated .Person.PhoneNumber phones = 4;
    public PhoneNumber[] phones;

    public Person() {
      clear();
    }

    public Person clear() {
      name = "";
      id = 0;
      email = "";
      phones = PhoneNumber.emptyArray();
      cachedSize = -1;
      return this;
    }

    @Override
    public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
        throws java.io.IOException {
      if (!this.name.equals("")) {
        output.writeString(1, this.name);
      }
      if (this.id != 0) {
        output.writeInt32(2, this.id);
      }
      if (!this.email.equals("")) {
        output.writeString(3, this.email);
      }
      if (this.phones != null && this.phones.length > 0) {
        for (int i = 0; i < this.phones.length; i++) {
          PhoneNumber element = this.phones[i];
          if (element != null) {
            output.writeMessage(4, element);
          }
        }
      }
      super.writeTo(output);
    }

    @Override
    protected int computeSerializedSize() {
      int size = super.computeSerializedSize();
      if (!this.name.equals("")) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeStringSize(1, this.name);
      }
      if (this.id != 0) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeInt32Size(2, this.id);
      }
      if (!this.email.equals("")) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeStringSize(3, this.email);
      }
      if (this.phones != null && this.phones.length > 0) {
        for (int i = 0; i < this.phones.length; i++) {
          PhoneNumber element = this.phones[i];
          if (element != null) {
            size += com.google.protobuf.nano.CodedOutputByteBufferNano
              .computeMessageSize(4, element);
          }
        }
      }
      return size;
    }

    @Override
    public Person mergeFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 10: {
            this.name = input.readString();
            break;
          }
          case 16: {
            this.id = input.readInt32();
            break;
          }
          case 26: {
            this.email = input.readString();
            break;
          }
          case 34: {
            int arrayLength = com.google.protobuf.nano.WireFormatNano
                .getRepeatedFieldArrayLength(input, 34);
            int i = this.phones == null ? 0 : this.phones.length;
            PhoneNumber[] newArray =
                new PhoneNumber[i + arrayLength];
            if (i != 0) {
              System.arraycopy(this.phones, 0, newArray, 0, i);
            }
            for (; i < newArray.length - 1; i++) {
              newArray[i] = new PhoneNumber();
              input.readMessage(newArray[i]);
              input.readTag();
            }
            // Last one without readTag.
            newArray[i] = new PhoneNumber();
            input.readMessage(newArray[i]);
            this.phones = newArray;
            break;
          }
        }
      }
    }

    public static Person parseFrom(byte[] data)
        throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
      return com.google.protobuf.nano.MessageNano.mergeFrom(new Person(), data);
    }

    public static Person parseFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      return new Person().mergeFrom(input);
    }
  }

  public static final class AddressBook extends
      com.google.protobuf.nano.MessageNano {

    private static volatile AddressBook[] _emptyArray;
    public static AddressBook[] emptyArray() {
      // Lazily initializes the empty array
      if (_emptyArray == null) {
        synchronized (
            com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
          if (_emptyArray == null) {
            _emptyArray = new AddressBook[0];
          }
        }
      }
      return _emptyArray;
    }

    // repeated .Person people = 1;
    public Person[] people;

    public AddressBook() {
      clear();
    }

    public AddressBook clear() {
      people = Person.emptyArray();
      cachedSize = -1;
      return this;
    }

    @Override
    public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
        throws java.io.IOException {
      if (this.people != null && this.people.length > 0) {
        for (int i = 0; i < this.people.length; i++) {
          Person element = this.people[i];
          if (element != null) {
            output.writeMessage(1, element);
          }
        }
      }
      super.writeTo(output);
    }

    @Override
    protected int computeSerializedSize() {
      int size = super.computeSerializedSize();
      if (this.people != null && this.people.length > 0) {
        for (int i = 0; i < this.people.length; i++) {
          Person element = this.people[i];
          if (element != null) {
            size += com.google.protobuf.nano.CodedOutputByteBufferNano
              .computeMessageSize(1, element);
          }
        }
      }
      return size;
    }

    @Override
    public AddressBook mergeFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 10: {
            int arrayLength = com.google.protobuf.nano.WireFormatNano
                .getRepeatedFieldArrayLength(input, 10);
            int i = this.people == null ? 0 : this.people.length;
            Person[] newArray =
                new Person[i + arrayLength];
            if (i != 0) {
              System.arraycopy(this.people, 0, newArray, 0, i);
            }
            for (; i < newArray.length - 1; i++) {
              newArray[i] = new Person();
              input.readMessage(newArray[i]);
              input.readTag();
            }
            // Last one without readTag.
            newArray[i] = new Person();
            input.readMessage(newArray[i]);
            this.people = newArray;
            break;
          }
        }
      }
    }

    public static AddressBook parseFrom(byte[] data)
        throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
      return com.google.protobuf.nano.MessageNano.mergeFrom(new AddressBook(), data);
    }

    public static AddressBook parseFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      return new AddressBook().mergeFrom(input);
    }
  }
}