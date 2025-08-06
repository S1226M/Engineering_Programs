# Hospital Hub Video Call Application

A complete video calling solution built with React frontend and ASP.NET Core backend, using VideoSDK for video communication.

## 🚀 Features

- **Two-Way Video Calling**: High-quality video communication between multiple participants
- **Real-time Audio**: Crystal clear audio transmission
- **Meeting Controls**: Mute/unmute microphone, enable/disable camera, leave meeting
- **Dynamic Room Creation**: Create new rooms or join existing ones
- **Responsive UI**: Modern, mobile-friendly interface
- **Error Handling**: Comprehensive error handling and user feedback

## 🛠 Technology Stack

### Frontend
- **React 19.1.0** - Modern React with latest features
- **VideoSDK React SDK** - Video calling functionality
- **Axios** - HTTP client for API calls
- **Vite** - Fast development build tool

### Backend
- **ASP.NET Core 8.0** - High-performance web API
- **JWT Authentication** - Secure token-based authentication for VideoSDK
- **Swagger/OpenAPI** - API documentation and testing

## 📋 Prerequisites

Before running this application, make sure you have:

1. **Node.js** (v18 or higher)
2. **.NET 8.0 SDK**
3. **VideoSDK Account** - Get your API credentials from [videosdk.live](https://videosdk.live)

## 🔧 Setup Instructions

### 1. Clone and Navigate
```bash
git clone <repository-url>
cd "Video Call"
```

### 2. Backend Setup

#### Navigate to Backend Directory
```bash
cd VideoCallAPI
```

#### Configure VideoSDK Credentials
Edit `appsettings.json` and replace the placeholder values with your actual VideoSDK credentials:

```json
{
  "VideoSDK": {
    "APIKey": "your_actual_videosdk_api_key",
    "SecretKey": "your_actual_videosdk_secret_key"
  }
}
```

**How to get VideoSDK credentials:**
1. Visit [videosdk.live](https://videosdk.live)
2. Sign up for a free account
3. Go to Dashboard → API Keys
4. Copy your API Key and Secret Key

#### Install Dependencies and Run
```bash
dotnet restore
dotnet run
```

The backend will start at `https://localhost:7200`

### 3. Frontend Setup

#### Navigate to Frontend Directory
```bash
cd ../HospitalHubVideoCall-Client
```

#### Install Dependencies
```bash
npm install
```

#### Start Development Server
```bash
npm run dev
```

The frontend will start at `http://localhost:5173`

## 🎯 How to Use

### Starting a Video Call

1. **Open the Application**: Navigate to `http://localhost:5173` in your browser
2. **Enter Your Name**: Type your display name
3. **Create or Join Room**:
   - **Create New Room**: Click "Create New Room" to start a new meeting
   - **Join Existing Room**: Enter a Room ID and click "Join Room"

### During the Call

- **Camera Control**: Click the 📹 button to turn camera on/off
- **Microphone Control**: Click the 🎤 button to mute/unmute
- **Leave Meeting**: Click the 📞 button to end the call

### Sharing Room with Others

- Share the **Room ID** displayed at the top of the video call screen
- Others can enter this Room ID to join your call

## 🔗 API Endpoints

### Backend API (https://localhost:7200/api/VideoSDK)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/token` | Get authentication token for VideoSDK |
| POST | `/create-meeting` | Create a new meeting room |
| GET | `/validate-meeting/{meetingId}` | Validate meeting ID |

### Example API Usage

```javascript
// Get authentication token
const response = await axios.get('https://localhost:7200/api/VideoSDK/token');
const token = response.data.token;

// Create new meeting
const meetingResponse = await axios.post('https://localhost:7200/api/VideoSDK/create-meeting', {
  title: "My Meeting",
  hostName: "John Doe"
});
```

## 🔧 Development

### Frontend Development
```bash
cd HospitalHubVideoCall-Client
npm run dev          # Start development server
npm run build        # Build for production
npm run preview      # Preview production build
npm run lint         # Run ESLint
```

### Backend Development
```bash
cd VideoCallAPI
dotnet run           # Start development server
dotnet build         # Build the project
dotnet test          # Run tests (if any)
```

## 🚨 Troubleshooting

### Common Issues

1. **"Failed to connect to the server"**
   - Make sure the backend is running at `https://localhost:7200`
   - Check if CORS is properly configured
   - Verify SSL certificate is trusted

2. **"VideoSDK API credentials not configured"**
   - Ensure you've added your actual VideoSDK API Key and Secret Key to `appsettings.json`
   - Restart the backend after updating credentials

3. **Video/Audio not working**
   - Grant browser permissions for camera and microphone
   - Ensure you're using HTTPS (required for WebRTC)
   - Try refreshing the page

4. **HTTPS Certificate Issues**
   ```bash
   # Trust the ASP.NET Core HTTPS development certificate
   dotnet dev-certs https --trust
   ```

### Browser Compatibility

This application works best on modern browsers that support WebRTC:
- ✅ Chrome 70+
- ✅ Firefox 70+  
- ✅ Safari 12+
- ✅ Edge 79+

## 🔒 Security Notes

- The application uses HTTPS for secure communication
- JWT tokens are used for VideoSDK authentication
- CORS is configured to allow cross-origin requests
- In production, configure CORS to allow only specific origins

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📞 Support

If you encounter any issues:

1. Check this README for troubleshooting steps
2. Verify your VideoSDK credentials
3. Ensure both backend and frontend are running
4. Check browser console for error messages

## 🎉 Features Roadmap

- [ ] Chat messaging during video calls
- [ ] Screen sharing functionality  
- [ ] Meeting recording
- [ ] Virtual backgrounds
- [ ] Meeting scheduling
- [ ] User authentication
- [ ] Database integration for meeting history

---

**Happy Video Calling!** 🎥📞
