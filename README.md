# Cryptography Library

A comprehensive Java implementation of various cryptographic algorithms, including classical ciphers, modern encryption standards, hash functions, and cryptanalysis tools.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Algorithms Implemented](#algorithms-implemented)
- [Cryptanalysis Tools](#cryptanalysis-tools)
- [Utility Classes](#utility-classes)
- [Getting Started](#getting-started)
- [Usage Examples](#usage-examples)
- [Security Disclaimer](#security-disclaimer)

## 🔍 Overview

This project is a comprehensive cryptography library written in Java that demonstrates the implementation of various encryption algorithms, hash functions, and cryptanalysis techniques. It serves as both an educational tool and a practical implementation of fundamental cryptographic concepts.

## ✨ Features

- **Classical Ciphers**: Caesar Cipher, Vigenère Cipher
- **Modern Symmetric Encryption**: AES (Advanced Encryption Standard), DES (Data Encryption Standard)
- **Asymmetric Encryption**: RSA (Rivest-Shamir-Adleman)
- **Elliptic Curve Cryptography**: ECC implementation with point operations
- **One-Time Pad**: Theoretically unbreakable encryption
- **Hash Functions**: MD5, SHA-256
- **Cryptanalysis Tools**: Brute force attacks, frequency analysis
- **Mathematical Utilities**: Prime testing, modular arithmetic, discrete logarithm

## 🔐 Algorithms Implemented

### Classical Ciphers

#### Caesar Cipher
- **Description**: Substitution cipher with a fixed shift value
- **Key Features**: Configurable alphabet and shift key
- **Security**: Vulnerable to frequency analysis and brute force

#### Vigenère Cipher
- **Description**: Polyalphabetic substitution cipher using a keyword
- **Key Features**: Variable-length keys, periodic encryption pattern
- **Security**: More secure than Caesar cipher but still vulnerable to cryptanalysis

### Modern Symmetric Encryption

#### Advanced Encryption Standard (AES)
- **Description**: Current standard for symmetric encryption
- **Implementation**: Uses Java's built-in cryptographic libraries
- **Mode**: CBC mode with PKCS5 padding
- **Key Features**: 128-bit block size, secure key generation

#### Data Encryption Standard (DES)
- **Description**: Legacy symmetric encryption standard
- **Implementation**: Uses Java's built-in cryptographic libraries
- **Mode**: CBC mode with PKCS5 padding
- **Note**: Included for educational purposes (not recommended for production)

### Asymmetric Encryption

#### RSA (Rivest-Shamir-Adleman)
- **Description**: Public-key cryptosystem based on integer factorization
- **Key Features**: 
  - Configurable key size (1024-bit demonstrated)
  - Secure random key generation
  - Public/private key pair generation
- **Applications**: Secure message transmission, digital signatures

#### Elliptic Curve Cryptography (ECC)
- **Description**: Public-key cryptography based on elliptic curve mathematics
- **Key Features**:
  - Point addition and doubling operations
  - Scalar multiplication using double-and-add algorithm
  - Diffie-Hellman key exchange demonstration

### One-Time Pad
- **Description**: Theoretically unbreakable encryption method
- **Key Features**: Random key generation equal to message length
- **Security**: Perfect secrecy when used correctly

### Hash Functions

#### MD5
- **Description**: 128-bit cryptographic hash function
- **Note**: Included for educational purposes (cryptographically broken)

#### SHA-256
- **Description**: 256-bit cryptographic hash function
- **Security**: Part of the SHA-2 family, currently secure

## 🔓 Cryptanalysis Tools

### Caesar Cipher Attacks

#### Brute Force Attack
- **Method**: Tries all possible shift values (1-26)
- **Detection**: Uses language detection to identify correct plaintext
- **Complexity**: O(|alphabet|)

#### Frequency Analysis Attack
- **Method**: Analyzes character frequencies in ciphertext
- **Technique**: Compares with expected English letter frequencies
- **Assumption**: Ciphertext follows English language patterns

## 🛠️ Utility Classes

- **Constants**: Common cryptographic constants and alphabets
- **DiffieHellman**: Key exchange protocol implementation
- **DiscreteLogarithm**: Discrete logarithm problem solving
- **ExtendedEuclideanAlgorithm**: For computing modular inverses
- **FermatPrimeTest**: Probabilistic primality testing
- **FileProcessor**: File I/O operations for cryptographic data
- **FrequencyAnalysis**: Character frequency analysis tools
- **GreatestCommonDivisor**: GCD computation
- **IntegerFactorization**: Integer factorization algorithms
- **LanguageDetector**: English language detection for cryptanalysis
- **ModularInverse**: Modular arithmetic operations
- **NaivePrimeTest**: Basic primality testing
- **Point**: Elliptic curve point representation
- **RandomGenerator**: Cryptographically secure random number generation

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- IDE with Java support (VS Code, IntelliJ IDEA, Eclipse)

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/dragos06/Cryptography.git
   ```

2. Navigate to the project directory:
   ```bash
   cd Cryptography
   ```

3. Compile the Java files:
   ```bash
   javac -d bin src/**/*.java
   ```

## 💡 Usage Examples

### Running the Demo Application

```bash
java -cp bin App
```

This will run demonstrations of all implemented algorithms with sample inputs and outputs.

### Using Individual Algorithms

#### Caesar Cipher Example
```java
CaesarCipher cipher = new CaesarCipher(3);
String plaintext = "HELLO WORLD";
String ciphertext = cipher.encrypt(plaintext);
String decrypted = cipher.decrypt(ciphertext);
```

#### RSA Example
```java
RSA rsa = new RSA();
rsa.generateKeys(1024);
BigInteger encrypted = rsa.encryptMessage("Secret Message");
String decrypted = rsa.decryptMessage(encrypted);
```

#### AES Example
```java
AdvancedEncryptionStandard aes = new AdvancedEncryptionStandard();
String ciphertext = aes.encrypt("Confidential Data");
String plaintext = aes.decrypt(ciphertext);
```

## ⚠️ Security Disclaimer

This implementation is intended for educational purposes. For production use:
- Use well-tested cryptographic libraries (Java Cryptography Extension)
- Follow current security best practices
- Avoid using deprecated algorithms (DES, MD5) in production
- Implement proper key management
- Use secure random number generation
