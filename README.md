# BOYON OMS — Android Application

Native Android App for the **BOYON Order Management System (OMS)** (`https://aio-vault-manager.vercel.app`).

---

## 📱 Features

- **Direct Live Synchronization**: Connects seamlessly with the live production dashboard and Supabase database. Any order updates, courier changes, or sales entries instantly reflect in real-time.
- **Over-The-Air Zero-Downtime Updates**: Whenever new dashboard features or bug fixes are deployed to the web, the Android application updates instantly without requiring staff to reinstall the APK.
- **Hardware Integration Readiness**:
  - **Camera Barcode / QR Scanning**: Requests native camera permissions to allow instant barcode scanning of parcels and product SKUs.
  - **Native Haptics**: JavaScript bridge (`Android.triggerHaptic('heavy')`) for physical confirmation buzzes during packing verification.
  - **File & Camera Chooser**: Supports photo capture and file upload for advance payment receipts and delivery slips.
- **Swipe-to-Refresh**: Native pull-to-refresh gesture styled in Boyon emerald branding.
- **Offline Resilience**: Automatically detects network loss and shows an offline retry screen.
- **Hardware Back Navigation**: Intercepts the Android back button to navigate history smoothly, with a double-tap confirmation to exit.

---

## 🚀 How to Build & Download the APK

### Method 1: Automatic Cloud Build (GitHub Actions) — Recommended

You don't need Android Studio or Java installed on your computer.

1. Push this directory to your GitHub repository (or create a new repo `boyon-oms-android` on your GitHub account).
2. Go to the **Actions** tab on your GitHub repository.
3. Click on the **Build Boyon OMS Android APK** workflow and click **Run workflow**.
4. Once completed (~2 minutes), download the compiled **`Boyon-OMS-v1.0.apk`** artifact directly to your phone.
5. Tap on the downloaded APK on your Android device to install!

### Method 2: Local Build via Android Studio

1. Open **Android Studio** and select **Open** -> choose `d:\my projects\boyon oms`.
2. Let Gradle sync project dependencies.
3. Go to **Build** -> **Build Bundle(s) / APK(s)** -> **Build APK(s)**.
4. Android Studio will generate the debug/release APK under `app/build/outputs/apk/`.

---

## 🛠️ Tech Stack & Specs

- **Target SDK**: Android 14 (API Level 34)
- **Minimum SDK**: Android 8.0 Oreo (API Level 26)
- **Language**: Kotlin 1.9+
- **Gradle**: 8.7
- **UI Architecture**: Edge-to-Edge Material Components + SwipeRefreshLayout + AndroidX WebKit
- **Package Name**: `com.boyon.oms`
