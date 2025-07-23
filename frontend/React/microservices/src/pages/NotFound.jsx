import { Box, Typography, Button } from '@mui/material';
import { useNavigate } from 'react-router-dom';

const NotFound = () => {
  const navigate = useNavigate();

  return (
    <Box
      display="flex"
      flexDirection="column"
      alignItems="center"
      justifyContent="center"
      minHeight="70vh"
      sx={{
        textAlign: 'center',
        px: 2,
      }}
    >
      <Typography
        variant="h1"
        color="primary"
        fontWeight={900}
        sx={{
          fontSize: { xs: 64, sm: 112 },
          textShadow: '0 2px 16px #5987ca33',
        }}
        gutterBottom
      >
        404
      </Typography>
      <Typography
        variant="h5"
        fontWeight={700}
        color="text.secondary"
        gutterBottom
      >
        Page Not Found
      </Typography>
      <Typography variant="body1" sx={{ mb: 4, color: "text.secondary" }}>
        Oops! The page you’re looking for doesn’t exist.
      </Typography>
      <Button
        variant="contained"
        color="primary"
        size="large"
        onClick={() => navigate('/')}
        sx={{ fontWeight: 600 }}
      >
        Go Home
      </Button>
    </Box>
  );
};

export default NotFound;
