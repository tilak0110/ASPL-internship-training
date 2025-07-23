import {
  Typography,
  Button,
  AppBar,
  Toolbar,
  IconButton,
  Drawer,
  List,
  ListItem,
  TextField,
  Card,
  CardContent,
  Grid,
  Avatar,
  Paper,
  Switch,
  Slider,
  Alert,
  Chip,
  Divider,
  Checkbox,
  Tabs,
  Tab,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  MenuItem,
  Select,
  Snackbar,
  Accordion,
  AccordionSummary,
  AccordionDetails,
  CircularProgress,
  LinearProgress,
  Badge,
  Tooltip,
  Stepper,
  Step,
  StepLabel,
  Radio,
  RadioGroup,
  FormControl,
  FormControlLabel,
  FormLabel,
  Box,
} from '@mui/material';

import MenuIcon from '@mui/icons-material/Menu';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import MailIcon from '@mui/icons-material/Mail';
import InboxIcon from '@mui/icons-material/Inbox';

import { useState } from 'react';
import * as styles from './style';

function App() {
  const [drawerOpen, setDrawerOpen] = useState(false);
  const [snackOpen, setSnackOpen] = useState(false);
  const [switchOn, setSwitchOn] = useState(true);
  const [tabValue, setTabValue] = useState(0);
  const [stepActive, setStepActive] = useState(1);
  const [radioValue, setRadioValue] = useState('female');
  const [selectValue, setSelectValue] = useState(10);
  const [textValue, setTextValue] = useState('');

  const handleTabChange = (event, newValue) => setTabValue(newValue);
  const handleRadioChange = (event) => setRadioValue(event.target.value);
  const handleSelectChange = (event) => setSelectValue(event.target.value);
  const steps = ['Step 1', 'Step 2', 'Step 3'];

  return (
    <div css={styles.rootContainer}>
      {/* top bar - probably dont need much here tbh */}
      <AppBar position="static">
        <Toolbar>
          <IconButton color="inherit" onClick={() => setDrawerOpen(true)} edge="start">
            <MenuIcon />
          </IconButton>
          <Typography variant="h6" sx={{ flexGrow: 1 }}>
            MU Showcase (just for fun)
          </Typography>
          <Button color="inherit" onClick={() => setSnackOpen(true)}>
            Wanna Snack?
          </Button>
        </Toolbar>
      </AppBar>

      <Drawer open={drawerOpen} onClose={() => setDrawerOpen(false)}>
        <List sx={{ width: 250 }}>
          <ListItem button>
            <InboxIcon sx={{ marginRight: 1 }} />
            <Typography>Inbox (not working)</Typography>
          </ListItem>
          <ListItem button>
            <MailIcon sx={{ marginRight: 1 }} />
            <Typography>Sent Mail (also not working yet)</Typography>
          </ListItem>
          <ListItem button>
            <Typography>Random menu</Typography>
          </ListItem>
        </List>
      </Drawer>

      <Typography variant="h3" css={styles.customHeading}>
        Welcomee to material UI heaven <span role="img" aria-label="sparkles">✨</span>
      </Typography>

      <Grid container spacing={4}>
        {/* Left */}
        <Grid item xs={12} md={6}>
          <Paper sx={styles.paperStyle}>
            <Typography variant="h5" gutterBottom>
              Btn Zone & toggles
            </Typography>
            <Box sx={{ '& > *': { m: 1 } }}>
              <Tooltip title="Primary contained button">
                <Button variant="contained" color="primary">
                  Primary
                </Button>
              </Tooltip>
              <Button variant="outlined" color="secondary">
                Secondary
              </Button>
              <Button variant="text" color="success">
                more text (success)
              </Button>
            </Box>

            <Box sx={{ mt: 3 }}>
              <Typography gutterBottom>Switchh</Typography>
              <Switch checked={switchOn} onChange={() => setSwitchOn(!switchOn)} />
            </Box>

            <Box sx={{ mt: 3 }}>
              <Typography gutterBottom>slide this →</Typography>
              <Slider defaultValue={30} />
            </Box>

            <Box sx={{ mt: 3 }}>
              <Chip label="Styled Chip" color="primary" />
              <Chip label="Click me" color="secondary" onClick={() => alert('yep, clicked!')} />
              <Chip label="Nope" disabled />
            </Box>
          </Paper>
        </Grid>

        {/* Right */}
        <Grid item xs={12} md={6}>
          <Card>
            <CardContent>
              <Avatar
                src="https://mui.com/static/images/avatar/1.jpg"
                sx={{ margin: 'auto', width: 100, height: 100, mb: 2 }}
                alt="jus a user lol"
              />
              <TextField
                label="Type Anything"
                fullWidth
                margin="normal"
                value={textValue}
                onChange={(e) => setTextValue(e.target.value)}
                helperText="say smth here... idk"
              />
              <Alert severity="success" sx={{ mt: 2 }}>
                it works! nicee job!
              </Alert>
            </CardContent>
          </Card>
        </Grid>
      </Grid>

      <Divider sx={{ my: 4 }} />

      <Accordion>
        <AccordionSummary expandIcon={<ExpandMoreIcon />}>
          <Typography>what does this do?</Typography>
        </AccordionSummary>
        <AccordionDetails>
          <Typography>it's just an accordion, nuthin special tbh</Typography>
        </AccordionDetails>
      </Accordion>
      <Accordion>
        <AccordionSummary expandIcon={<ExpandMoreIcon />}>
          <Typography>another one</Typography>
        </AccordionSummary>
        <AccordionDetails>
          <Typography>Lorem ipsum dolor sit amet, you know how it is!... 🙃</Typography>
        </AccordionDetails>
      </Accordion>

      <Divider sx={{ my: 4 }} />

      {/* Progress bits */}
      <Grid container spacing={4} justifyContent="center" alignItems="center" sx={{ mb: 4 }}>
        <Grid item>
          <CircularProgress color="primary" />
        </Grid>
        <Grid item xs={6}>
          <LinearProgress variant="determinate" value={50} />
        </Grid>
      </Grid>

      {/* Table */}
      <TableContainer component={Paper} sx={{ mb: 4 }}>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell>Stuff</TableCell>
              <TableCell align="right">Detailz</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            <TableRow>
              <TableCell>Checked?</TableCell>
              <TableCell align="right">
                <Checkbox defaultChecked />
              </TableCell>
            </TableRow>
            <TableRow>
              <TableCell>Select menu</TableCell>
              <TableCell align="right">
                <Select value={selectValue} onChange={handleSelectChange}>
                  <MenuItem value={10}>Ten</MenuItem>
                  <MenuItem value={20}>Twentyy</MenuItem>
                  <MenuItem value={30}>Thirty (well... almost)</MenuItem>
                </Select>
              </TableCell>
            </TableRow>
          </TableBody>
        </Table>
      </TableContainer>

      {/* Tabs */}
      <Tabs value={tabValue} onChange={handleTabChange} sx={{ mb: 3 }}>
        <Tab label="stuff 1" />
        <Tab label="tab Two" />
        <Tab label="Tab3" />
      </Tabs>

      {/* Stepper */}
      <Stepper activeStep={stepActive} sx={{ mb: 4 }} alternativeLabel>
        {steps.map((label) => (
          <Step key={label}>
            <StepLabel>{label}</StepLabel>
          </Step>
        ))}
      </Stepper>
      <Box sx={{ textAlign: 'center', mb: 6 }}>
        <Button
          disabled={stepActive === 0}
          onClick={() => setStepActive((prev) => Math.max(prev - 1, 0))}
          sx={{ mr: 2 }}
        >
          Backk
        </Button>
        <Button
          disabled={stepActive === steps.length - 1}
          variant="contained"
          onClick={() => setStepActive((prev) => Math.min(prev + 1, steps.length - 1))}
        >
          Go Next!
        </Button>
      </Box>

      {/* Radios */}
      <FormControl component="fieldset" sx={{ mb: 6 }}>
        <FormLabel component="legend">Choose Gender maybe?</FormLabel>
        <RadioGroup row aria-label="gender" name="gender" value={radioValue} onChange={handleRadioChange}>
          <FormControlLabel value="female" control={<Radio />} label="Female" />
          <FormControlLabel value="male" control={<Radio />} label="Male" />
          <FormControlLabel value="other" control={<Radio />} label="Other" />
        </RadioGroup>
      </FormControl>

      {/* Badge + tooltip */}
      <Box sx={{ textAlign: 'center', mb: 8 }}>
        <Tooltip title="4 new mails... i never check these lol">
          <Badge badgeContent={4} color="secondary">
            <MailIcon fontSize="large" />
          </Badge>
        </Tooltip>
      </Box>

      {/* Footer */}
      <Paper sx={{ py: 3, px: 2, backgroundColor: '#1565c0', color: 'white', textAlign: 'center', borderRadius: '12px' }}>
        <Typography variant="body1">
          &copy; 2025 myCompany (jk, it's just a demo). All rights reserved, or maybe not.
        </Typography>
      </Paper>

      <Snackbar
        open={snackOpen}
        autoHideDuration={4000}
        onClose={() => setSnackOpen(false)}
        message="Hello from MUI! 🙌"
      />
    </div>
  );
}

export default App;
