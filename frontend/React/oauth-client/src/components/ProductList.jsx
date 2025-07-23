import { useEffect, useState } from "react";
import { fetchProducts, createProduct, deleteProduct } from "../services/ProductService";
import { useAuth } from "../config/authcontext";

import {
  Card,
  CardContent,
  Typography,
  TextField,
  Button,
  List,
  ListItem,
  ListItemText,
  IconButton,
  Stack,
  Divider,
} from "@mui/material";
import DeleteIcon from "@mui/icons-material/Delete";
import AddIcon from "@mui/icons-material/Add";

const ProductList = () => {
  const { keycloakInstance } = useAuth();
  const [products, setProducts] = useState([]);
  const [newProduct, setNewProduct] = useState({ name: "", description: "" });

  const loadProducts = () => {
    if (keycloakInstance?.token) {
      fetchProducts(keycloakInstance.token)
        .then(setProducts)
        .catch((err) => console.error("Error loading products:", err));
    }
  };

  useEffect(() => {
    loadProducts();
  }, [keycloakInstance]);

  const handleAddProduct = async () => {
    if (!newProduct.name.trim()) return;
    try {
      await createProduct(newProduct, keycloakInstance.token);
      setNewProduct({ name: "", description: "" });
      loadProducts();
    } catch (err) {
      console.error("Error adding product:", err);
    }
  };

  const handleDelete = async (id) => {
    try {
      await deleteProduct(id, keycloakInstance.token);
      loadProducts();
    } catch (err) {
      console.error("Error deleting product:", err);
    }
  };

  return (
    <Card sx={{ marginTop: 4, padding: 2 }}>
      <CardContent>
        <Typography variant="h5" gutterBottom>
          Product List
        </Typography>

        {/* Add Product Form */}
        <Stack direction={{ xs: 'column', sm: 'row' }} spacing={2} mb={3}>
          <TextField
            label="Name"
            value={newProduct.name}
            onChange={(e) => setNewProduct({ ...newProduct, name: e.target.value })}
            fullWidth
          />
          <TextField
            label="Description"
            value={newProduct.description}
            onChange={(e) => setNewProduct({ ...newProduct, description: e.target.value })}
            fullWidth
          />
          <Button
            variant="contained"
            color="primary"
            onClick={handleAddProduct}
            startIcon={<AddIcon />}
          >
            Add
          </Button>
        </Stack>

        {/* Product List */}
        <List>
          {products.map((prod) => (
            <div key={prod.id}>
              <ListItem
                secondaryAction={
                  <IconButton edge="end" color="error" onClick={() => handleDelete(prod.id)}>
                    <DeleteIcon />
                  </IconButton>
                }
              >
                <ListItemText
                  primary={prod.name}
                  secondary={prod.description}
                />
              </ListItem>
              <Divider />
            </div>
          ))}
        </List>
      </CardContent>
    </Card>
  );
};

export default ProductList;
